import { Injectable } from '@angular/core';
import { Apollo } from 'apollo-angular';
import { gql } from 'apollo-angular';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ClientService {
  constructor(private apollo: Apollo) {}

  fetchListClients(): Observable<any> {
    return this.apollo.query({
      query: gql`
        query {
          fetchListClients {
            id
            nom
            prenom
            email
            telephone
          }
        }
      `
    });
  }

  fetchClientById(id: string): Observable<any> {
    return this.apollo.query({
      query: gql`
        query($id: ID!) {
          fetchClientById(id: $id) {
            id
            nom
            prenom
            email
            telephone
          }
        }
      `,
      variables: { id }
    });
  }

  createClient(input: any): Observable<any> {
    return this.apollo.mutate({
      mutation: gql`
        mutation($input: ClientREQ!) {
          createClient(input: $input) {
            id
            nom
            prenom
            email
            telephone
          }
        }
      `,
      variables: { input }
    });
  }

  updateClient(id: string, input: any): Observable<any> {
    return this.apollo.mutate({
      mutation: gql`
        mutation($id: ID!, $input: ClientREQ!) {
          updateClient(id: $id, input: $input) {
            id
            nom
            prenom
            email
            telephone
          }
        }
      `,
      variables: { id, input }
    });
  }

  deleteClient(id: string): Observable<any> {
    return this.apollo.mutate({
      mutation: gql`
        mutation($id: ID!) {
          deleteClient(id: $id)
        }
      `,
      variables: { id }
    });
  }

  fetchPaginatedClients(page: number, size: number, sortBy: string = 'id', orderBy: string = 'desc'): Observable<any> {
    return this.apollo.query({
      query: gql`
        query($page: Int, $size: Int, $sortBy: String, $orderBy: String) {
          fetchPaginatedClients(page: $page, size: $size, sortBy: $sortBy, orderBy: $orderBy) {
            content {
              id
              nom
              prenom
              email
              telephone
              reservations {
                id
                // ...other reservation fields
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
            totalElements
            totalPages
            last
            first
            size
            number
            numberOfElements
            empty
          }
        }
      `,
      variables: { page, size, sortBy, orderBy }
    });
  }
}
