import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Location } from 'src/app/models/location/location.model';

const baseUrl = 'http://localhost:8080/api/hm/location';
const allLocationsUrl = 'http://localhost:8080/api/hm/location/alllocations';
const getByIdUrl = 'http://localhost:8080/api/hm/location/find';
const updateByIdUrl = 'http://localhost:8080/api/hm/location/update';
const deleteByIdUrl = 'http://localhost:8080/api/hm/location/remove';
const addNewLocationUrl = 'http://localhost:8080/api/hm/location/newlocation';

@Injectable({
  providedIn: 'root'
})
export class LocationService {

  constructor(private http: HttpClient) { }

  getAll(): Observable<Location[]> {
    return this.http.get<Location[]>(allLocationsUrl);
  }

  get(id: any): Observable<Location> {
    return this.http.get(`${getByIdUrl}/${id}`);
  }

  create(data: any): Observable<any> {
    return this.http.post(addNewLocationUrl, data);
  }

  update(id: any, data: any): Observable<any> {
    return this.http.put(`${updateByIdUrl}/${id}`, data);
  }

  delete(id: any): Observable<any> {
    return this.http.delete(`${deleteByIdUrl}/${id}`);
  }

  // deleteAll(): Observable<any> {
  //   return this.http.delete(baseUrl);
  // }

  // findByTitle(title: any): Observable<Location[]> {
  //   return this.http.get<Location[]>(`${baseUrl}?title=${title}`);
  // }
}
