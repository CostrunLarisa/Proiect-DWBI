import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { NavbarComponent } from './navbar/navbar.component';
import {FormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import { SignupComponent } from './signup/signup.component';
import { ShopComponent } from './shop/shop.component';
import { OrderComponent } from './order/order.component';
import { ProductComponent } from './product/product.component';
import { NewproductComponent } from './newproduct/newproduct.component';
import { NewshopComponent } from './newshop/newshop.component';
import { ShopsproductsComponent } from './shopsproducts/shopsproducts.component';
import { ErrorInterceptorComponent } from './error-interceptor/error-interceptor.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    NavbarComponent,
    SignupComponent,
    ShopComponent,
    OrderComponent,
    ProductComponent,
    ErrorInterceptorComponent,
    ProductComponent,
    NewproductComponent,
    NewshopComponent,
    ShopsproductsComponent
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        FormsModule,
        HttpClientModule,
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
