import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Product } from '../model/product';
import {Observable, Subscription} from "rxjs";

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

  public save(product : Product) {

    return this.http.post('//localhost:8080/api/v1/products', product).subscribe(request => {
    });
  }

  public edit(product : Product) {
    return this.http.put<Product>('//localhost:8080/api/v1/products/'+ product.id, product).subscribe(request => {
    });
  }



}
