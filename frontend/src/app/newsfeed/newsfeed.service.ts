import {Injectable} from '@angular/core';
import {Observable} from "rxjs/Observable";
import {NewsfeedChallenge} from "./newsfeed-challenge";
import {HttpClient} from "@angular/common/http";
import {UrlService} from "../utils/url.service";

@Injectable({
  providedIn: 'root'
})
export class NewsfeedService {

  baseUrl: string = this.urlService.getBaseUrl() + "newfeed/";

  constructor(private urlService: UrlService,
              private httpClient: HttpClient) {
  }

  public getNewsfeed(): Observable<NewsfeedChallenge[]> {
    let url = this.baseUrl;
    return this.httpClient.get<NewsfeedChallenge[]>(url);
  }
}
