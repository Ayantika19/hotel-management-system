import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Items } from 'src/app/models/items/items.model';

const baseUrl = 'http://localhost:8080/api/hm/items';

@Injectable({
  providedIn: 'root'
})
export class ItemsService {

  constructor(private http: HttpClient) { }

  getAll(): Observable<Items[]> {
    return this.http.get<Items[]>(baseUrl);
  }

  get(itemId: any): Observable<Items> {
    return this.http.get(`${baseUrl}/${itemId}`);
  }

  create(data: any): Observable<any> {
    return this.http.post(baseUrl, data);
  }

  update(itemId: any, data: any): Observable<any> {
    return this.http.put(`${baseUrl}/${itemId}`, data);
  }

  delete(itemId: any): Observable<any> {
    return this.http.delete(`${baseUrl}/${itemId}`);
  }

  // deleteAll(): Observable<any> {
  //   return this.http.delete(baseUrl);
  // }

  // findByTitle(title: any): Observable<Location[]> {
  //   return this.http.get<Location[]>(`${baseUrl}?title=${title}`);
  // }
}
