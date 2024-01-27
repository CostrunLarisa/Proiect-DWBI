import { Component, OnInit } from '@angular/core';
import {HttpClient, HttpHeaders, HttpResponse} from "@angular/common/http";
import {ActivatedRoute, Route, Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  user: any = {
    username : '',
    password : ''
  };
  errorMessage: string = '';

  constructor(private http: HttpClient, private router: Router, private route: ActivatedRoute) {}

  ngOnInit(): void {
  }

  login() {
    const apiUrl = 'http://localhost:8080/login';
    const headers = new HttpHeaders({
      'Content-Type': 'application/x-www-form-urlencoded',
      'Access-Control-Allow-Origin': 'http://localhost:4200'
    });
    console.log(this.user.username)
    console.log(this.user.password)
    const body = `username=${this.user.username}&password=${this.user.password}`
    this.http.post(apiUrl, body, {  headers : headers, observe: 'response' } ).subscribe(
      (response : HttpResponse<any>) => {

        const responseHeaders: HttpHeaders = response.headers;
        console.log(response.headers);
        setTimeout(() => {
          this.router.navigate(['/shop', {headers: responseHeaders}]);
          console.log('Login successful', response);
        }, 3000);
      },
      (error) => {
        console.error('Login failed', error);
        this.errorMessage = 'Invalid username or password';
      }
    );
  }
}
