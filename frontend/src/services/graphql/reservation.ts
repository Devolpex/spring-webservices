import { gql } from "@apollo/client";

// Query to get the list of reservations
export const GET_RESERVATIONS_LIST = gql`
  query GetReservationsList {
    getReservationsList {
      id
      dateDebut
      dateFin
      preferences
      client {
        id
        nom
        prenom
        email
        telephone
      }
      chambre {
        id
        type
        prix
        disponible
      }
    }
  }
`;

// Query to get paginated reservations
export const GET_PAGINATED_RESERVATIONS = gql`
  query GetPaginatedReservations(
    $page: Int
    $size: Int
    $sortBy: String
    $orderBy: String
  ) {
    getPaginatedReservations(
      page: $page
      size: $size
      sortBy: $sortBy
      orderBy: $orderBy
    ) {
      totalElements
      totalPages
      last
      first
      size
      number
      numberOfElements
      empty
      content {
        id
        dateDebut
        dateFin
        preferences
        client {
          id
          nom
          prenom
          email
          telephone
        }
        chambre {
          id
          type
          prix
          disponible
        }
      }
      pageable {
        pageNumber
        pageSize
        offset
        paged
        unpaged
        sort {
          sorted
          unsorted
          empty
        }
      }
    }
  }
`;
