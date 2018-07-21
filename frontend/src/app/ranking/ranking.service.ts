import {Injectable} from '@angular/core';
import {UrlService} from "../utils/url.service";
import {HttpClient} from "@angular/common/http";
import {NewsfeedChallenge} from "../newsfeed/newsfeed-challenge";
import {Observable} from "rxjs/Observable";
import {Ranking} from "./ranking";

@Injectable({
  providedIn: 'root'
})
export class RankingService {


  baseUrl: string = this.urlService.getBaseUrl() + "ranking/";

  constructor(private urlService: UrlService,
              private httpClient: HttpClient) {
  }

  public getRankings(): Observable<Ranking[]> {
    let url = this.baseUrl;
    return this.httpClient.get<Ranking[]>(url);
  }
}
