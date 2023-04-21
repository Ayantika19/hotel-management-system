import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Reservation } from 'src/app/models/reservation/reservation.model';

const baseUrl = 'http://localhost:8080/api/hm/reservation';

@Injectable({
  providedIn: 'root'
})
export class ReservationService {

  constructor(private http: HttpClient) { }

  getAll(): Observable<Reservation[]> {
    return this.http.get<Reservation[]>(baseUrl);
  }

  get(bookingId: any): Observable<Reservation> {
    return this.http.get(`${baseUrl}/${bookingId}`);
  }

  create(data: any): Observable<any> {
    return this.http.post(baseUrl, data);
  }

  update(bookingId: any, data: any): Observable<any> {
    return this.http.put(`${baseUrl}/${bookingId}`, data);
  }

  delete(bookingId: any): Observable<any> {
    return this.http.delete(`${baseUrl}/${bookingId}`);
  }

  // deleteAll(): Observable<any> {
  //   return this.http.delete(baseUrl);
  // }

  // findByTitle(title: any): Observable<Location[]> {
  //   return this.http.get<Location[]>(`${baseUrl}?title=${title}`);
  // }
}
