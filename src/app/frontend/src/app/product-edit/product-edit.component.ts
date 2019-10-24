import { Component } from '@angular/core';

import { Product } from '../model/product';
import {ProductServiceService} from "../services/product.service";

@Component({
    selector: 'app-product-edit',
    templateUrl: './product-edit.component.html',
    styleUrls: ['./product-edit.component.css']
})
export class ProductEditComponent {
    constructor(private productService : ProductServiceService) { }
  // TODO: Fill this product with backend data if editing!
    model = new Product();
    submitted = false;

    onSubmit() {
        this.submitted = true;
      this.productService.save(this.model);
    };

    newProduct() {
        this.model = new Product();

    };
}
