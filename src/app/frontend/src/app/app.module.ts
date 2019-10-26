import { BrowserModule } from '@angular/platform-browser';
import { NgModule, LOCALE_ID } from '@angular/core';
import localeEs from '@angular/common/locales/es';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MenuComponent } from './menu/menu.component';
import { LoginComponent } from './login/login.component';

import { FormsModule } from '@angular/forms';
import { LogoutComponent } from './logout/logout.component';
import { HttpInterceptorService } from './httpInterceptor.service';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import {ProductComponent} from "./product/product.component";
import {ProductEditComponent} from "./product-edit/product-edit.component";
import { NavbarComponent } from './navbar/navbar.component';
import { registerLocaleData } from '@angular/common';
import { ProductViewComponent } from './product-view/product-view.component';
import {HomeComponent} from "./home/home.component";
import { PriceReductionComponent } from './price-reduction/price-reduction.component';
import { AddSupplierComponent } from './add-supplier/add-supplier.component';
import { DeactivateItemComponent } from './deactivate-item/deactivate-item.component';

registerLocaleData(localeEs);
@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    MenuComponent,
    LoginComponent,
    LogoutComponent,
    ProductComponent,
    ProductViewComponent,
    ProductEditComponent,
    NavbarComponent,
    PriceReductionComponent,
    AddSupplierComponent,
    DeactivateItemComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [
    {
      provide: LOCALE_ID,
      useValue: 'es-ES'
    },
    {
      provide: HTTP_INTERCEPTORS,
      useClass: HttpInterceptorService,
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
