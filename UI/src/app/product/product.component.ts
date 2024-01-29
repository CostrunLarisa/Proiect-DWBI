import { Component, OnInit } from '@angular/core';
import {AuthService} from "../authservice";
import {Router} from "@angular/router";

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {


  constructor(private authService: AuthService, private router : Router) { }

  ngOnInit(): void {
    if (!this.authService.isLoggedIn()) {
      this.router.navigate(['/error']);
    }
  }
}
