import { Component, OnInit } from '@angular/core';
import {
  HttpErrorResponse,
  HttpEvent,
  HttpHandler,
  HttpHeaders,
  HttpInterceptor,
  HttpRequest
} from "@angular/common/http";
import {catchError, Observable, throwError} from "rxjs";
import {Router} from "@angular/router";

@Component({
  selector: 'app-error-interceptor',
  templateUrl: './error-interceptor.component.html',
  styleUrls: ['./error-interceptor.component.css']
})
export class ErrorInterceptorComponent implements HttpInterceptor {

  constructor(private router : Router) {
    this.router = router;
  }

  ngOnInit(): void {
  }

  login() {
    this.router.navigate(['/login']);
  }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'Access-Control-Allow-Origin': 'http://localhost:8080'
    });
    // @ts-ignore
    return next.handle(req).pipe(
      // @ts-ignore
      catchError((error: HttpErrorResponse) => {
          if (error.status === 401) {
            this.router.navigate(['/error', {headers:headers}]);
          }
      }))}
}
