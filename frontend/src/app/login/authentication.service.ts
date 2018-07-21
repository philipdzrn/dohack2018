import { Injectable } from '@angular/core';
import {UrlService} from "../utils/url.service";

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor(private urlService: UrlService) { }

  baseUrl: string = this.urlService.getBaseUrl() + "/auth";

  public login() {
    let url = this.baseUrl + "/login";

    alert("login");
  }

  public register() {
    let url = this.baseUrl + "/register";

    alert("register");
  }


}
