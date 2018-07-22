import {Injectable} from '@angular/core';
import {UrlService} from "../utils/url.service";
import {UserCredentials} from "./user-credentials";
import {HttpClient} from "@angular/common/http";
import {User} from "./user";

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor(private urlService: UrlService,
              private httpClient: HttpClient) {
  }

  baseUrl: string = this.urlService.getBaseUrl() + "auth";
  currentUserIdStorageKey: string = "currentUserId";

  public login(credentials: UserCredentials) {

    let url = this.baseUrl + "/login";

    this.httpClient.post(url, credentials).subscribe((user: User) => {
      this.saveUserIdToSessionStorage(user.id);
    });
  }

  public register(credentials: UserCredentials) {
    let url = this.baseUrl + "/register";

    this.httpClient.post(url, credentials).subscribe((user: User) => {
      this.saveUserIdToSessionStorage(user.id);
    });
  }

  private saveUserIdToSessionStorage(userId: number): void {
    sessionStorage.setItem(this.currentUserIdStorageKey, userId + "");
  }

  public getCurrentUserId(): string {
    let userId = sessionStorage.getItem(this.currentUserIdStorageKey);

    if(!userId) {
      return "";
    } else {
      return userId;
    }
  }
}
