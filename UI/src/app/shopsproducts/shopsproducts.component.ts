import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {AuthService} from "../authservice";


@Component({
  selector: 'app-shopsproducts',
  templateUrl: './shopsproducts.component.html',
  styleUrls: ['./shopsproducts.component.css']
})
export class ShopsproductsComponent implements OnInit {

  shopProductsList: any[] = [];
  shopId: any;
  constructor(private authService: AuthService,
              private route: ActivatedRoute,
              private http: HttpClient,
              private router: Router) { }

  ngOnInit(): void {
    if (!this.authService.isLoggedIn()) {
      this.router.navigate(['/error']);
    }
    this.route.params.subscribe(params => {
      this.shopId=params['shopId'];
      this.getAllProductsFromShop(this.shopId);
    });
  }

  getAllProductsFromShop(shopId: any){
    const headers = new HttpHeaders({
      // @ts-ignore
      'Authorization-Token': this.authService.getAuthToken(),
      'Content-Type': 'application/json',
      'Access-Control-Allow-Origin': 'http://localhost:4200'
    });
    this.http.get<any[]>(`http://localhost:8080/products/shop/${shopId}`, {  headers }).subscribe(

      (data) => {
        this.shopProductsList = data;
        console.log(this.shopProductsList)
        console.log(this.authService.getAuthToken())
      },
      (error) => {
        console.error('Error fetching data:', error);
        console.log(this.shopProductsList)
        console.log(this.authService.getAuthToken())
      }
    );
  }

  goToShops(){
    this.router.navigate(['/shops']);
  }


}
