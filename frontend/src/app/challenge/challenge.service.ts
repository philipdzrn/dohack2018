import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {AuthenticationService} from "../login/authentication.service";
import {UrlService} from "../utils/url.service";
import {Challenge} from "./challenge";

@Injectable({
  providedIn: 'root'
})
export class ChallengeService {

  baseUrl: string = this.urlService.getBaseUrl() + "challenges/";

  constructor(private urlService: UrlService,
              private httpClient: HttpClient,
              private authenticationService: AuthenticationService,
  ) {
  }

  public getChallenges(): Observable<Challenge> {
    let userId = this.authenticationService.getCurrentUserId();

    let url = this.baseUrl + userId;

    return this.httpClient.get<Challenge>(url);
  }

  public updateChallenge(challenge: Challenge) {

    // TODO
  }
}
