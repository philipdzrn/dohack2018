import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {UrlService} from "../utils/url.service";
import {Observable} from "rxjs/Observable";
import {User} from "../login/user";

@Injectable({
  providedIn: 'root'
})
export class UserService {
  baseUrl: string = this.urlService.getBaseUrl() + "/users";

  constructor(private urlService: UrlService,
              private httpClient: HttpClient) {
  }

  public getUser(id: String): Observable<User> {
    let url = this.baseUrl + "/" + id;
    return this.httpClient.get<User>(url);
  }

}
