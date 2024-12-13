import { createBrowserRouter } from "react-router-dom";
import { LayoutGraphQL } from "./layout/LayoutGraphQL";
import { ReservationGraphQLPage } from "./pages/ReservationGraphQLPage";

const routes = createBrowserRouter([
  {
    path: "/graphql",
    element: <LayoutGraphQL />,
    children: [
      {
        path: "/graphql/reservation/page/",
        element: <ReservationGraphQLPage />,
      },
    ],
  },
]);

export default routes;