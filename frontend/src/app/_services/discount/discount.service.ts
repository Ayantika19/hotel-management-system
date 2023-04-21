import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Discount } from 'src/app/models/discount/discount.model';

const baseUrl = 'http://localhost:8080/api/hm/discount';

@Injectable({
  providedIn: 'root'
})
export class DiscountService {

  constructor(private http: HttpClient) { }

  getAll(): Observable<Discount[]> {
    return this.http.get<Discount[]>(baseUrl);
  }

  get(discountId: any): Observable<Discount> {
    return this.http.get(`${baseUrl}/${discountId}`);
  }

  create(data: any): Observable<any> {
    return this.http.post(baseUrl, data);
  }

  update(discountId: any, data: any): Observable<any> {
    return this.http.put(`${baseUrl}/${discountId}`, data);
  }

  delete(discountId: any): Observable<any> {
    return this.http.delete(`${baseUrl}/${discountId}`);
  }

  // deleteAll(): Observable<any> {
  //   return this.http.delete(baseUrl);
  // }

  // findByTitle(title: any): Observable<Discount[]> {
  //   return this.http.get<Discount[]>(`${baseUrl}?title=${title}`);
  // }
}
