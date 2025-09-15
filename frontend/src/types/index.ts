export interface Page<T> {
  content: T[];
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


// Fetch Params
export interface FetchParams {
  page: number;
  size: number;
  sortBy: string;
  orderBy: string;
}