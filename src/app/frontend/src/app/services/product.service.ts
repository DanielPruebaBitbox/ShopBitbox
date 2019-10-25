import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Product } from '../model/product';
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ProductServiceService {
  private productUrl: string;
  private currentProduct: Product;
  constructor(private http: HttpClient) {
    this.productUrl = '//localhost:8080/api/v1/products'
  }

  public setCurrentProduct(product: Product): void {
    this.currentProduct = product;
  }
  public getCurrentProduct(): Product {
    return this.currentProduct;
  }

  public findAll():Observable<any> {
    return this.http.get(this.productUrl);
  }

  public save(product : Product): Observable<any> {
    console.log("trato de crearlo");
    return this.http.post<Product>(this.productUrl, product);
  }

  public edit(product : Product): Observable<any> {
    return this.http.put<Product>(this.productUrl + product.id, product);
  }

}
