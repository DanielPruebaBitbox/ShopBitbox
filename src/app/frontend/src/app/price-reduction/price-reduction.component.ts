import {Component, Input, OnInit} from '@angular/core';
import { PriceReduction} from "../model/priceReduction";
import {ProductServiceService} from "../services/product.service";
import {Product} from "../model/product";


@Component({
  selector: 'app-price-reduction',
  templateUrl: './price-reduction.component.html',
  styleUrls: ['./price-reduction.component.css']
})
export class PriceReductionComponent implements OnInit {
  @Input()
  edit?: Boolean = false;
  @Input()
  model?: Product = new Product();
  priceReduction?: PriceReduction = new PriceReduction();
  emptyProduct = new Product();
  constructor(
    private productService : ProductServiceService
  ) {this.model = productService.getCurrentProduct();
    if(this.model.id) this.edit = true;
    this.model.priceReduction.push(this.priceReduction);
  }

  ngOnInit() {
  }

  addPriceReduction($event){
    $event.preventDefault();
    this.productService.setCurrentProduct(this.emptyProduct);
    this.model.priceReduction.push(this.priceReduction);
    this.productService.edit(this.model);
  }

}
