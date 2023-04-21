import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Location } from 'src/app/models/location/location.model';

const baseUrl = 'http://localhost:8080/api/hm/location';

@Injectable({
  providedIn: 'root'
})
export class LocationService {

  constructor(private http: HttpClient) { }

  getAll(): Observable<Location[]> {
    return this.http.get<Location[]>(baseUrl);
  }

  get(locationId: any): Observable<Location> {
    return this.http.get(`${baseUrl}/${locationId}`);
  }

  create(data: any): Observable<any> {
    return this.http.post(baseUrl, data);
  }

  update(locationId: any, data: any): Observable<any> {
    return this.http.put(`${baseUrl}/${locationId}`, data);
  }

  delete(locationId: any): Observable<any> {
    return this.http.delete(`${baseUrl}/${locationId}`);
  }

  // deleteAll(): Observable<any> {
  //   return this.http.delete(baseUrl);
  // }

  // findByTitle(title: any): Observable<Location[]> {
  //   return this.http.get<Location[]>(`${baseUrl}?title=${title}`);
  // }
}
