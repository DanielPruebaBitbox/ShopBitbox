import {Component, Input, OnInit} from '@angular/core';
import {Product} from "../model/product";
import {Suppliers} from "../model/suppliers";
import {ProductServiceService} from "../services/product.service";
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-supplier',
  templateUrl: './add-supplier.component.html',
  styleUrls: ['./add-supplier.component.css']
})

export class AddSupplierComponent implements OnInit {
  @Input()
  edit?: Boolean = false;
  @Input()
  model?: Product = new Product();
  supplierModel?: Suppliers = new Suppliers();
  emptyProduct = new Product();

  constructor(  private productService : ProductServiceService) {
    this.model = productService.getCurrentProduct();
    if (this.model){this.edit = true;
      this.model.suppliers.push(this.supplierModel);
    }
  }
  ngOnInit() {
  }

  addSupplier($event){
    $event.preventDefault();
    this.productService.setCurrentProduct(this.emptyProduct);
    this.model.suppliers.push(this.supplierModel);
    this.productService.edit(this.model);
  }

}
