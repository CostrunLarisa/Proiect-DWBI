import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  constructor(private http: HttpClient,
              private router: Router) { }

  ngOnInit(): void {
  }

  goToHistory() {
    this.router.navigate(['/orders']);
  }

  goToShops() {
    this.router.navigate(['/shop']);
  }

  goToCart() {
    this.router.navigate(['/cart']);
  }
}
