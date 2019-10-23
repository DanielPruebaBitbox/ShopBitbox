import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Product } from '../model/product';
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ProductServiceService {
  private productUrl: string;
  constructor(private http: HttpClient) {
    this.productUrl = 'htpp://localhost:8080/api/v1/products'
  }

  public findAll():Observable<Product[]>{
    return this.http.get<Product[]>(this.productUrl)
  }

  public save(product : Product) {
    return this.http.post<Product>(this.productUrl, product);
  }
}
