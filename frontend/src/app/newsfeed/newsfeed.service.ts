import {Injectable} from '@angular/core';
import {Observable} from "rxjs/Observable";
import {of} from 'rxjs/observable/of';
import {Challenge} from "../challenge/challenge";

@Injectable({
  providedIn: 'root'
})
export class NewsfeedService {

  constructor() {
  }

  public getNewsfeed(): Observable<Challenge[]> {

    let feed: Challenge[] = [];
    let challenge = new Challenge();
    challenge.name = "Peter";
    challenge.description = "Beschreibung";

    feed.push(challenge);
    feed.push(challenge);

    return of(feed);

  }
}
