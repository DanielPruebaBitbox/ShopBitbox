import { Component, OnInit } from '@angular/core';
import { Product} from "../model/product";
import { ProductServiceService} from "../Service/product-service.service";

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {
  product : Product[];
  constructor(private productService : ProductServiceService) { }

  ngOnInit() {
    this.productService.findAll().subscribe(data =>{
      this.product = data});
  }

}
