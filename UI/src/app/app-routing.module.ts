import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {LoginComponent} from "./login/login.component";
import {SignupComponent} from "./signup/signup.component";
import {ShopComponent} from "./shop/shop.component";
import {ErrorInterceptorComponent} from "./error-interceptor/error-interceptor.component";
import {OrderHistoryComponent} from "./order-history/order-history.component";
import {CartComponent} from "./cart/cart.component";

const routes: Routes = [
  {path: 'login', component:LoginComponent},
  {path: 'signup', component:SignupComponent},
  {path: 'shop', component:ShopComponent},
  {path: 'orders/history', component:OrderHistoryComponent},
  {path: 'cart', component: CartComponent},
  {path: 'error', component: ErrorInterceptorComponent}
]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
