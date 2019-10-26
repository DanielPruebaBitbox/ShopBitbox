import {Component, Input, OnInit} from '@angular/core';
import { PriceReduction} from "../model/priceReduction";
import {ProductServiceService} from "../services/product.service";
import {Product} from "../model/product";
import {Router} from "@angular/router";


@Component({
  selector: 'app-price-reduction',
  templateUrl: './price-reduction.component.html',
  styleUrls: ['./price-reduction.component.css']
})
export class PriceReductionComponent implements OnInit {

  @Input()
  model?: Product = new Product();
  priceReduction?: PriceReduction = new PriceReduction();
  emptyProduct = new Product();
  constructor(
    private productService : ProductServiceService, private router: Router
  ) {
    this.model = productService.getCurrentProduct();
    }

  ngOnInit() {
  }

  addPriceReduction($event){
    $event.preventDefault();

    this.productService.setCurrentProduct(this.emptyProduct);
    this.model.priceReduction.push(this.priceReduction);
    this.productService.edit(this.model);
    this.router.navigate(['/home']);
  }

}
