import { Component, OnInit } from '@angular/core';
import {AuthService} from "../authservice";
import {Router} from "@angular/router";

@Component({
  selector: 'app-shop',
  templateUrl: './shop.component.html',
  styleUrls: ['./shop.component.css']
})
export class ShopComponent implements OnInit {


  constructor(private authService: AuthService, private router : Router) { }

  ngOnInit(): void {
    if (!this.authService.isLoggedIn()) {
      this.router.navigate(['/error']);
    }
  }
}
