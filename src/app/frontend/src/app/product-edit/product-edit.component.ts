import { Component, Input } from '@angular/core';

import { Product } from '../model/product';
import { ProductServiceService } from '../services/product.service';

@Component({
  selector: 'app-product-edit',
  templateUrl: './product-edit.component.html',
  styleUrls: ['./product-edit.component.css']
})
export class ProductEditComponent {
  // Create mode -> edit = false
  // Edit mode -> edit = true
  // Create mode if no flag provided
  @Input()
  edit?: Boolean = false;
  // If edit mode, call the component with a
  // Product object to edit, empty Product by default
  @Input()
  model?: Product = new Product();

  emptyProduct = new Product()
  constructor(
    private productService : ProductServiceService
  ) {this.model = productService.getCurrentProduct();
    if(this.model.id) this.edit = true;
    console.log(this.model)
  }
  // Component called like
  // <app-product-edit [edit]="true" [model]="myProduct"></app-product-edit>

  onSubmit() {
    console.log(this.model);
    this.productService.setCurrentProduct(this.emptyProduct);
    console.log(this.productService.getCurrentProduct())
    console.log("edit + "+   this.edit);
    if (this.edit) {
      this.productService.edit(this.model);
    } else {
      this.productService.save(this.model);
    }

  };

  newProduct() {
    this.model = new Product();
  };
}
