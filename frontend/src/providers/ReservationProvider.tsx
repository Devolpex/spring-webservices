/* eslint-disable react-refresh/only-export-components */
import React, { createContext, useContext, useState, ReactNode } from "react";
import { FetchParams } from "../types";

// Define the context type
interface ReservationContextType {
  fetchParams: FetchParams;
  setFetchParams: (fetchParams: FetchParams) => void;
}

// Create the context with a default value
const ReservationContext = createContext<ReservationContextType | undefined>(
  undefined
);

interface ReservationProviderProps {
  children: ReactNode;
}

export const ReservationProvider: React.FC<ReservationProviderProps> = ({
  children,
}) => {
  const [fetchParams, setFetchParams] = useState<FetchParams>({
    page: 1,
    size: 5,
    sortBy: "id",
    orderBy: "desc",
  });

  return (
    <ReservationContext.Provider
      value={{
        fetchParams,
        setFetchParams,
      }}
    >
      {children}
    </ReservationContext.Provider>
  );
};

// Custom hook to use the context
export const useReservationContext = (): ReservationContextType => {
  const context = useContext(ReservationContext);
  if (context === undefined) {
    throw new Error(
      "useReservationContext must be used within a ReservationProvider"
    );
  }
  return context;
};
