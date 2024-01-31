import { Component, OnInit } from '@angular/core';
import {AuthService} from "../authservice";
import {ActivatedRoute, Router} from "@angular/router";
import {HttpClient, HttpHeaders} from "@angular/common/http";

@Component({
  selector: 'app-shop',
  templateUrl: './shop.component.html',
  styleUrls: ['./shop.component.css']
})
export class ShopComponent implements OnInit {
  shops: any[] = [];
  constructor(private authService: AuthService,
              private route: ActivatedRoute,
              private router : Router,
              private http: HttpClient,) { }

  ngOnInit(): void {
    if (!this.authService.isLoggedIn()) {
      this.router.navigate(['/error']);
    }
    this.route.params.subscribe(params => {
      this.getShops();
    });
  }

  private getShops() {
    const headers = new HttpHeaders({
      // @ts-ignore
      'Authorization-Token': this.authService.getAuthToken(),
      'Content-Type': 'application/json',
      'Access-Control-Allow-Origin': 'http://localhost:8080'
    });
    this.http.get<any[]>('http://localhost:8080/shops', {headers}).subscribe(
      (response: any) => {
        this.shops = response;
      },
      (error) => {
        console.error('Error fetching data:', error);
      }
    );
  }
}
