import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import Elements from '../models/element.model';


@Injectable({
  providedIn: 'root'
})
export class PeriodicTableService {

  constructor(
    private http: HttpClient
  ) { }

  getElements() {
    return this.http.get<Elements>('/assets/json/periodic-table.json');
  }
}
