import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {HttpClient, HttpHeaders} from "@angular/common/http";

@Component({
  selector: 'app-newproduct',
  templateUrl: './newproduct.component.html',
  styleUrls: ['./newproduct.component.css']
})
export class NewproductComponent implements OnInit {

  product: any= {};
  errorMessage: string ="";
  shops:any[]=[];


  constructor( private route: ActivatedRoute, private http: HttpClient, private router: Router){}


  ngOnInit(){

    this.getAllShops();
  }
  getAllShops(){

    // @ts-ignore
    const headers = new HttpHeaders({

      'Content-Type': 'application/json',
      'Access-Control-Allow-Origin': 'http://localhost:8080'
    });

    this.http.get<any[]>('http://localhost:8080/shops', {  headers }).subscribe(
      (data) => {
        this.shops = data;
      },
      (error) => {
        console.error('Error fetching data:', error);
      }
    );
  }
  submit(){
    const apiUrl = 'http://localhost:8080/products/add';

    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'Access-Control-Allow-Origin': 'http://localhost:8080'
    });
    // Make sure to adjust the URL and request payload according to your API
    const newProduct = this.product
    this.http.post(apiUrl, this.product, { headers: headers }).subscribe(
      (response) => {
        // Handle successful login response
        console.log('Product added', response);
        this.router.navigate(['/products']);
      },
      (error) => {
        // Handle login error
        console.error('Could not add product', error);
        this.errorMessage = this.errorMessage; // Display an error message to the user
      }
    );
  }

}
