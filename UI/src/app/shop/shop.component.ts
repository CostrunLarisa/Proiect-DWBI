import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";
// import {AuthService} from "../authservice";

@Component({
  selector: 'app-shop',
  templateUrl: './shop.component.html',
  styleUrls: ['./shop.component.css']
})
export class ShopComponent implements OnInit {

  shopsList:any[]=[];
  // constructor( private authService : AuthService, private http: HttpClient, private router: Router) { }
  constructor(  private http: HttpClient, private router: Router) { }

  ngOnInit(): void {
    // if (!this.authService.isLoggedIn()) {
    //   this.router.navigate(['/error']);
    // }
    // else{
    this.getAllShops()
    // }

  }

  getAllShops(){
    // @ts-ignore
    const headers = new HttpHeaders({
      // @ts-ignore
      'Authorization-Token': this.authService.getAuthToken(),
      'Content-Type': 'application/json',
      'Access-Control-Allow-Origin': 'http://localhost:8081'
    });
    this.http.get<any[]>('http://localhost:8081/shops', {  headers }).subscribe(
      (data) => {
        this.shopsList = data;
      },
      (error) => {
        console.error('Error fetching data:', error);
      }
    );
  }

  goToShopProducts(shopId: any) {
    this.router.navigate(['/productsFromShop', shopId]);
  }

}
