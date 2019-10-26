import {Component, Input, OnInit} from '@angular/core';
import {Product} from "../model/product";
import { ProductServiceService } from '../services/product.service';
import {Router} from "@angular/router";

@Component({
  selector: 'app-deactivate-item',
  templateUrl: './deactivate-item.component.html',
  styleUrls: ['./deactivate-item.component.css']
})
export class DeactivateItemComponent implements OnInit {
  @Input()
  edit?: Boolean = false;
  // If edit mode, call the component with a
  // Product object to edit, empty Product by default
  @Input()
  model?: Product = new Product();
  constructor(   private productService : ProductServiceService,
                 private router: Router,
  ) {this.model = productService.getCurrentProduct();
  }

  ngOnInit() {
  }

  onSubmitDeactivate($event){
    $event.preventDefault();
    this.model.active = false;
    this.productService.edit(this.model);
    this.router.navigate(['/home']);
  }
}
