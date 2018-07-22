import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {AuthenticationService} from "../login/authentication.service";
import {UrlService} from "../utils/url.service";
import {Challenge, LikeByChallenge} from "./challenge";

@Injectable({
  providedIn: 'root'
})
export class ChallengeService {

  baseUrl: string = this.urlService.getBaseUrl();

  constructor(private urlService: UrlService,
              private httpClient: HttpClient,
              private authenticationService: AuthenticationService,
  ) {
  }

  public getChallenges(): Observable<Challenge[]> {
    let userId = this.authenticationService.getCurrentUserId();

    let url = this.baseUrl + "users/" + userId + "/challenges";

    return this.httpClient.get<Challenge[]>(url);
  }

  public getChallenge(id): Observable<Challenge> {
    let url = this.baseUrl + "challenges/" + id;
    return this.httpClient.get<Challenge>(url);
  }

  public updateChallenge(challengeId: number, value: number): Observable<any> {
    let url = this.baseUrl + "challenges/" + challengeId;

    let data = {
      currentValue: value
    };

    return this.httpClient.post(url, data);
  }

  public createChallenge(challenge: Challenge): Observable<any> {
    let url = this.baseUrl + "challenges/";
    return this.httpClient.post(url, challenge);
  }

  public likeChallenge(challengeId: number): Observable<any> {
    let url = this.baseUrl + "challenges/" + challengeId + "/like";

    const like = {
      currentValue: challengeId
    };

    return this.httpClient.post(url, like);
  }

  public getLikesByChallenge(challengeId: number): Observable<LikeByChallenge> {
    let url = this.baseUrl + "challenges/" + challengeId + "/likes";
    return this.httpClient.get<LikeByChallenge>(url);
  }
}
