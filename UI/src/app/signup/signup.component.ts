import { Component, OnInit } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Router} from "@angular/router";

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  user: any = {
    username: '',
    password: '',
    email: '',
    firstName: '',
    lastName: ''
  };
  errorMessage: string = '';

  constructor(private http: HttpClient, private router : Router) { }

  ngOnInit(): void {
  }

  signup() {

    const apiUrl = 'http://localhost:8080/signup';
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'Access-Control-Allow-Origin': 'http://localhost:4200'
    });

    this.http.post(apiUrl, this.user, {headers: headers}).subscribe(
      (response) => {
        this.router.navigate(['/login']);
        console.log('Signup successful', response);
      },
      (error) => {
        console.error('Signup failed', error);
        this.errorMessage = "Must complete with another username."
      }
    );
  }
}
