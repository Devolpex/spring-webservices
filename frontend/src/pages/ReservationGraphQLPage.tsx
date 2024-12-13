/* eslint-disable @typescript-eslint/no-unused-expressions */
import { useQuery } from "@apollo/client";
import { GET_PAGINATED_RESERVATIONS } from "../services/graphql/reservation";
import { useReservationContext } from "../providers/ReservationProvider";
import { Reservation } from "../types/reservation";
import { useEffect, useState } from "react";
import { ReservationsTable } from "../components/ReservationTable";

export interface IReservationGraphQLPageProps {
  children?: React.ReactNode;
  title?: string;
}

export function ReservationGraphQLPage(props: IReservationGraphQLPageProps) {
  // Context
  const { fetchParams, setFetchParams } = useReservationContext();

  const [reservations, setReservations] = useState<Reservation[]>([]);
  const [totalPage, setTotalPage] = useState<number>(0);

  // Query to fetch paginated reservations
  const { error, data } = useQuery(GET_PAGINATED_RESERVATIONS, {
    variables: {
      page: fetchParams.page,
      size: fetchParams.size,
      sortBy: fetchParams.sortBy,
      orderBy: fetchParams.orderBy,
    },
  });
  data ? console.log(data.getPaginatedReservations) : console.log(error);

  useEffect(() => {
    if (data) {
      setReservations(data.getPaginatedReservations.content);
      setTotalPage(data.getPaginatedReservations.totalPages);
      setFetchParams({
        ...fetchParams,
        page: data.getPaginatedReservations.pageable.pageNumber + 1,
        size: data.getPaginatedReservations.pageable.pageSize,
      });
    } else {
      console.log(error);
    }
  }, [data, error]);

  const headers = [
    "Client",
    "Chambre",
    "Date Debut",
    "Date Fin",
    "Preferences",
    "",
  ];

  return (
    <div>
      <h1>{props.title}</h1>
      {reservations && (
        <ReservationsTable
          headers={headers}
          rows={reservations}
          total={totalPage}
        />
      )}
    </div>
  );
}
