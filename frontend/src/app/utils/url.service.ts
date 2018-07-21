import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UrlService {

  constructor() { }

  public getBaseUrl() {
    return "http://localhost:8090/";
  }
}
