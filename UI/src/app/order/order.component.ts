import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {AuthService} from "../authservice";

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {

  constructor(private authService: AuthService,
              private router : Router) { }

  ngOnInit(): void {
    if (!this.authService.isLoggedIn()) {
      this.router.navigate(['/error']);
    }
  }

}
