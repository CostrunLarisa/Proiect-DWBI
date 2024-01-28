import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";
@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  productsList: any[] = [];

  constructor(  private http: HttpClient, private router: Router) { }

  ngOnInit(): void {

      this.getAllProducts();
  }

  getAllProducts(){
    // @ts-ignore
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'Access-Control-Allow-Origin': 'http://localhost:8080'
    });
    this.http.get<any[]>('http://localhost:8080/products', {  headers }).subscribe(
      (data) => {
        this.productsList = data;
      },
      (error) => {
        console.error('Error fetching data:', error);
      }
    );
  }

  goToAddProduct() {
    this.router.navigate(['/newProduct']);
  }

  goToShopsList(){
    this.router.navigate(['/shops']);
  }



}
