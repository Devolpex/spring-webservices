import { StrictMode } from "react";
import { createRoot } from "react-dom/client";
import "./index.css";
import { ThemeProvider } from "@material-tailwind/react";
import { RouterProvider } from "react-router-dom";
import routes from "./routes.tsx";
import { ApolloProvider } from "@apollo/client";
import graphqlClient from "./config/apollo.ts";

createRoot(document.getElementById("root")!).render(
  <StrictMode>
    <ThemeProvider>
      <ApolloProvider client={graphqlClient}>
        <RouterProvider router={routes} />
      </ApolloProvider>
    </ThemeProvider>
  </StrictMode>
);
