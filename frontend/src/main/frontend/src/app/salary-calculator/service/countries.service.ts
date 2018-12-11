import { Injectable, forwardRef, NgModule } from '@angular/core';
import { Http, RequestOptions, Headers, Response } from '@angular/http';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
import { Observable } from 'rxjs/Observable';
import { Countries } from '../model/Countries';

@Injectable()
export class CountriesService {
  uri = "/api/v1/calculator/countries";

    constructor(private http: Http) {}

    get(): Observable<Countries> {
        let headers = new Headers({ 'Content-Type': 'application/json' });
        let options = new RequestOptions({ headers: headers });

        return this.http
            .get(this.uri, {headers: headers})
            .map(res => res.json());
    }
}
