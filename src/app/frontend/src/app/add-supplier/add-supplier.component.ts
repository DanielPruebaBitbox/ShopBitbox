import {Component, Input, OnInit} from '@angular/core';
import {Product} from "../model/product";
import {Supplier} from "../model/supplier";
import {ProductServiceService} from "../services/product.service";
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-supplier',
  templateUrl: './add-supplier.component.html',
  styleUrls: ['./add-supplier.component.css']
})

export class AddSupplierComponent implements OnInit {
  model?: Product = new Product();
  supplierModel?: Supplier = new Supplier();
  emptyProduct = new Product();

  constructor(  private productService : ProductServiceService, private router: Router) {
    this.model = productService.getCurrentProduct();
  }
  ngOnInit() {
  }

  addSupplier($event){
    $event.preventDefault();

    this.model.supplier.push(this.supplierModel);
    this.productService.setCurrentProduct(this.emptyProduct);
    this.productService.edit(this.model);

    this.router.navigate(['/home']);
  }

}
