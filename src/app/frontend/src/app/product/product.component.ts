import { Component, OnInit, Input } from '@angular/core';
import { Product} from "../model/product";
import { ProductServiceService} from "../services/product.service";
import { Router } from '@angular/router';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {
  @Input()
  products : Product[] = [];
  emptyProduct = new Product();
  constructor(
    private router: Router,
    private productService : ProductServiceService
  ){ };

  ngOnInit() {
     this.productService.findAll().subscribe(data => {
       this.products = data;
     });
  }

  onDetailsView(product: Product) {
    this.productService.setCurrentProduct(product);
    this.router.navigate(['/products/view/', product.id]);
  }

  onEditView(product: Product) {
    this.productService.setCurrentProduct(product);
    this.router.navigate(['/products/edit/', product.id, { "edit":true}]);
  }
  addPriceReduction(product: Product){
    this.productService.setCurrentProduct(product);
    this.router.navigate(['/products/price/', product.id, { "edit":true}]);
  }

  supplierWindow(product: Product){
    this.productService.setCurrentProduct(product);
    this.router.navigate(['/products/supplier/', product.id, { "edit":true}]);
  }

  deactivateItem(product: Product){
    this.productService.setCurrentProduct(product);
    this.router.navigate(['/products/deactivate/', product.id, { "edit":true}]);
  }

  createProduct(product: Product){
    this.productService.setCurrentProduct(this.emptyProduct);
    this.router.navigate(['/products/new']);
  }


}
