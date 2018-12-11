import { Injectable, forwardRef, NgModule } from '@angular/core';
import { Http, RequestOptions, Headers, Response } from '@angular/http';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
import { Observable } from 'rxjs/Observable';
import { Salary } from '../model/Salary';

@Injectable()
export class SalaryCalculatorService {
   uri = "/api/v1/calculator/salary"

    constructor(private http: Http) {}

    calculate(amount: number, country: string): Observable<Salary> {
        let headers = new Headers({ 'Content-Type': 'application/json' });
        let options = new RequestOptions({ headers: headers });

        return this.http
            .get(this.uri, {headers: headers, params: {
                dailySalary: amount,
                country: country
            }})
            .map(res => res.json());
    }
}
