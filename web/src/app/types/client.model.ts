export interface ReservationDTO {
  // Define reservation fields if needed
  id?: number;
  // ...other fields
}

export interface ClientDTO {
  id: number;
  nom: string;
  prenom: string;
  email: string;
  telephone: string;
  reservations?: ReservationDTO[];
}

export interface Pageable {
  pageNumber: number;
  pageSize: number;
  offset: number;
  paged: boolean;
  unpaged: boolean;
  sort: Sort;
}

export interface Sort {
  sorted: boolean;
  unsorted: boolean;
  empty: boolean;
}

export interface ClientPage {
  content: ClientDTO[];
  pageable: Pageable;
  totalElements: number;
  totalPages: number;
  last: boolean;
  first: boolean;
  size: number;
  number: number;
  numberOfElements: number;
  empty: boolean;
}
