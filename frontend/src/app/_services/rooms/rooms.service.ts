import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Rooms } from 'src/app/models/rooms/rooms.model';

const baseUrl = 'http://localhost:8080/api/hm/rooms';

@Injectable({
  providedIn: 'root'
})
export class RoomsService {

  constructor(private http: HttpClient) { }

  getAll(): Observable<Rooms[]> {
    return this.http.get<Rooms[]>(baseUrl);
  }

  get(roomId: any): Observable<Rooms> {
    return this.http.get(`${baseUrl}/${roomId}`);
  }

  create(data: any): Observable<any> {
    return this.http.post(baseUrl, data);
  }

  update(roomId: any, data: any): Observable<any> {
    return this.http.put(`${baseUrl}/${roomId}`, data);
  }

  delete(roomId: any): Observable<any> {
    return this.http.delete(`${baseUrl}/${roomId}`);
  }
}
