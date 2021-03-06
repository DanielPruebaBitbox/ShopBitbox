import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { ProductEditComponent } from "./product-edit/product-edit.component";
import { ProductComponent } from './product/product.component';
import { ProductViewComponent } from './product-view/product-view.component';
import {HomeComponent} from "./home/home.component";
import {PriceReductionComponent} from "./price-reduction/price-reduction.component";
import {AddSupplierComponent} from "./add-supplier/add-supplier.component";
import {DeactivateItemComponent} from "./deactivate-item/deactivate-item.component";

const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: '', component: LoginComponent},
  {path: 'home', component: HomeComponent},
  {path: 'logout', component: LoginComponent},
  {path: 'products', component: ProductComponent},
  {path: 'products/view/:id', component: ProductViewComponent},
  {path: 'products/edit/:id', component: ProductEditComponent},
  {path: 'products/new', component: ProductEditComponent},
  {path: 'products/price/:id', component: PriceReductionComponent},
  {path: 'products/supplier/:id', component: AddSupplierComponent},
  {path: 'products/deactivate/:id', component: DeactivateItemComponent},
  {path: '', redirectTo: '', pathMatch: 'full'},
  {path: '**', redirectTo: '/login'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }
