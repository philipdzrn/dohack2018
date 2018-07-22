import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UrlService {

  constructor(private window: Window) { }

  public getBaseUrl() {
    let hostname = this.window.location.hostname;
    return "http://" + hostname + ":8090/";
  }
}
