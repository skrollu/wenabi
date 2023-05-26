import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Pageable } from '../../core/models/pageable';
import { Wish } from '../models/wish';

@Injectable({
  providedIn: 'root'
})
export class WishesService {
  private apiUrl = 'http://localhost:8080/api/wishes';

  constructor(private http: HttpClient) {}

  getPageableWishes(): Observable<Pageable<Wish>> {
    const headers = this.createBasicAuthHeaders('association_user', 'password');
    return this.http.get<Pageable<Wish>>(this.apiUrl, { headers });
  }

  private createBasicAuthHeaders(username: string, password: string): HttpHeaders {
    const authString = btoa(`${username}:${password}`);
    return new HttpHeaders({
      'Content-Type': 'application/json',
      Authorization: `Basic ${authString}`
    });
  }
}