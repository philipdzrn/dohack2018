import { Injectable } from '@angular/core';
import {UrlService} from "../utils/url.service";
import {UserCredentials} from "./user-credentials";

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor(private urlService: UrlService) { }

  baseUrl: string = this.urlService.getBaseUrl() + "/auth";

  public login(credentials: UserCredentials) {
    let url = this.baseUrl + "/login";

    alert("login");
  }

  public register(credentials: UserCredentials) {
    let url = this.baseUrl + "/register";

    alert("register");
  }


}
