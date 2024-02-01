import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {LoginComponent} from "./login/login.component";
import {SignupComponent} from "./signup/signup.component";
import {ShopComponent} from "./shop/shop.component";
import {NewshopComponent} from "./newshop/newshop.component";
import {ProductComponent} from "./product/product.component";
import {NewproductComponent} from "./newproduct/newproduct.component";
import {ShopsproductsComponent} from "./shopsproducts/shopsproducts.component";
import {ErrorInterceptorComponent} from "./error-interceptor/error-interceptor.component";
import {OrderHistoryComponent} from "./order-history/order-history.component";
import {CartComponent} from "./cart/cart.component";
import {OrderComponent} from "./order/order.component";

const routes: Routes = [
  {path: 'login', component:LoginComponent},
  {path: 'signup', component:SignupComponent},
  {path: 'error', component: ErrorInterceptorComponent},
  {path: 'shops', component:ShopComponent},
  {path: 'newshop', component:NewshopComponent},
  {path: 'products', component:ProductComponent},
  {path: 'newproduct', component:NewproductComponent},
  { path:'productsFromShop/:shopId', component: ShopsproductsComponent},
  {path: 'orders/history', component:OrderHistoryComponent},
  {path: 'cart', component: CartComponent},
  {path: 'error', component: ErrorInterceptorComponent},
  {path: 'orders', component: OrderComponent}
]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
