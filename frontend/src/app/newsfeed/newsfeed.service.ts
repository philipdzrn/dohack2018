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

    challenge.name = "Pushups";

    challenge.creator = "Peter";
    challenge.description = "Beschreibung";
    challenge.currentValue = 15;
    challenge.goal = 35;

    feed.push(challenge);
    feed.push(challenge);

    return of(feed);

  }
}
