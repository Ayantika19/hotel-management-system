import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Hotel } from 'src/app/models/hotel/hotel.model';

const baseUrl = 'http://localhost:8080/api/hm/hotel';

@Injectable({
  providedIn: 'root'
})
export class HotelService {

  constructor(private http: HttpClient) { }

  getAll(): Observable<Hotel[]> {
    return this.http.get<Hotel[]>(baseUrl);
  }

  get(hotelId: any): Observable<Hotel> {
    return this.http.get(`${baseUrl}/${hotelId}`);
  }

  create(data: any): Observable<any> {
    return this.http.post(baseUrl, data);
  }

  update(hotelId: any, data: any): Observable<any> {
    return this.http.put(`${baseUrl}/${hotelId}`, data);
  }

  delete(hotelId: any): Observable<any> {
    return this.http.delete(`${baseUrl}/${hotelId}`);
  }

  // deleteAll(): Observable<any> {
  //   return this.http.delete(baseUrl);
  // }

  // findByTitle(title: any): Observable<Location[]> {
  //   return this.http.get<Location[]>(`${baseUrl}?title=${title}`);
  // }
}
