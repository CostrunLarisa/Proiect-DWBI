import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {HttpClient, HttpHeaders} from "@angular/common/http";


@Component({
  selector: 'app-shopsproducts',
  templateUrl: './shopsproducts.component.html',
  styleUrls: ['./shopsproducts.component.css']
})
export class ShopsproductsComponent implements OnInit {

  shopProductsList: any[] = [];
  shopId: any;
  constructor(private route: ActivatedRoute, private http: HttpClient, private router: Router) { }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.shopId=params['shopId'];
      this.getAllProductsFromShop(this.shopId);
    });
  }

  getAllProductsFromShop(shopId: any){
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'Access-Control-Allow-Origin': 'http://localhost:8081'
    });
    // const params = new HttpParams().set('shopId',shopId)
    this.http.get<any[]>(`http://localhost:8081/products/shop/${shopId}`, {  headers }).subscribe(
      (data) => {
        this.shopProductsList = data;
      },
      (error) => {
        console.error('Error fetching data:', error);
      }
    );
  }

  goToShops(){
    this.router.navigate(['/shops']);
  }


}
