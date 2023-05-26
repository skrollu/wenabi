
export interface Pageable<T> {
  content: T[]; // page content de la page
  pageable: {
    pageNumber: number; // page number
    pageSize: number; // page size
  };
  totalPages: number; // total number of pages
  totalElements: number;
  last: boolean;
  first: boolean;
  size: number; 
  number: number; 
  numberOfElements: number; 
  empty: boolean;
}