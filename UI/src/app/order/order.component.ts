import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {AuthService} from "../authservice";
import {HttpClient, HttpHeaders} from "@angular/common/http";

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {
  orders: any[] = [];
  constructor(private authService: AuthService,
              private router : Router,
              private http: HttpClient) { }

  ngOnInit(): void {
    if (!this.authService.isLoggedIn()) {
      this.router.navigate(['/error']);
    }
    this.getOrders();
  }

  private getOrders() {
    const headers = new HttpHeaders({
      // @ts-ignore
      'Authorization-Token': this.authService.getAuthToken(),
      'Content-Type': 'application/json',
      'Access-Control-Allow-Origin': 'http://localhost:8080'
    });
    this.http.get<any[]>('http://localhost:8080/orders', {headers}).subscribe(
      (response: any) => {
        this.orders = response;
      },
      (error) => {
        console.error('Error fetching data:', error);
      }
    );
  }
}
