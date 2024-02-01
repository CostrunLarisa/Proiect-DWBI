import { Component, OnInit } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Router} from "@angular/router";


@Component({
  selector: 'app-newshop',
  templateUrl: './newshop.component.html',
  styleUrls: ['./newshop.component.css']
})
export class NewshopComponent implements OnInit {
  shop: any= {};
  errorMessage: string ="";

  constructor(  private http: HttpClient, private router: Router) { }

  ngOnInit(): void {}

  addShop(){
    const apiUrl = 'http://localhost:8081/shops/add';

    const headers = new HttpHeaders({

      'Content-Type': 'application/json',
      'Access-Control-Allow-Origin': 'http://localhost:8081'
    });

    this.http.post(apiUrl, this.shop, {headers}).subscribe(
      (response) => {
        // Handle successful response
        console.log('Shop added', response);
        this.router.navigate(['/shops']);
      },
      (error) => {
        // Handle error
        console.error('Could not add shop', error);
      }
    );
  }

}
