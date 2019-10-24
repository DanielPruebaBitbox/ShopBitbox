import { Component, OnInit } from '@angular/core';
import { Product} from "../model/product";
import { ProductServiceService} from "../services/product.service";

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {
  product : Product[];
  constructor(private productService : ProductServiceService) { }

  ngOnInit() {
    console.log("al menos estoy aquí");
    this.productService.findAll().subscribe(data =>{
      console.log("al menos entro");
      console.log(data);
      this.product = data});
  }

}
