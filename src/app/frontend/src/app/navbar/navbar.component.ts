import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {Product} from "../model/product";
import {ProductServiceService} from "../services/product.service";

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  emptyProduct = new Product();

  constructor(private router: Router, private productService : ProductServiceService){

  }

  ngOnInit() {
  }

  createProduct(product: Product){
    this.productService.setCurrentProduct(this.emptyProduct);
    this.router.navigate(['/products/new"']);
  }

}
