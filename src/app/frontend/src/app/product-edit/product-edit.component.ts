import { Component, Input } from '@angular/core';

import { Product } from '../model/product';
import { ProductServiceService } from '../services/product.service';
import {Router} from "@angular/router";

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
  emptyProduct = new Product();

  constructor(
    private productService : ProductServiceService, private router: Router
  ) {
    this.model = productService.getCurrentProduct();
    if(this.model) this.edit = true;
  }


  onSubmit() {
    this.productService.setCurrentProduct(this.emptyProduct);

    if (this.edit) {
      this.productService.edit(this.model);
      this.router.navigate(['/home']);
    } else {
      this.productService.save(this.model);
      this.router.navigate(['/home']);
    }
  };

}
