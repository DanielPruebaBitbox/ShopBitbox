import { Component, Input } from '@angular/core';

import { Product } from '../model/product';
import { ProductServiceService } from '../services/product.service';

@Component({
    selector: 'app-product-view',
    templateUrl: './product-view.component.html'//,
    // styleUrls: ['./product-view.component.css']
})
// TODO: Create .css file and modify as needed
export class ProductViewComponent {

    @Input()
    model: Product;

    constructor(
        private productService : ProductServiceService
    ) {
        this.model = productService.getCurrentProduct();

    }


}
