import {Injectable} from '@angular/core';
import {Observable} from "rxjs/Observable";
import {of} from 'rxjs/observable/of';
import {Challenge} from "../challenge/challenge";
import {NewsfeedChallenge} from "./newsfeed-challenge";
import {User} from "../login/user";

@Injectable({
  providedIn: 'root'
})
export class NewsfeedService {

  constructor() {
  }

  public getNewsfeed(): Observable<NewsfeedChallenge[]> {

    let feed: NewsfeedChallenge[] = [];

    let newsfeedChallenge = new NewsfeedChallenge();

    let challenge = new Challenge();

    challenge.name = "Pushups";

    let user = new User();
    user.name = "Peter";

    challenge.id = 2;
    challenge.creator = user;
    challenge.description = "Beschreibung";
    challenge.currentValue = 15;
    challenge.goal = 35;

    newsfeedChallenge.challengeDTO = challenge;

    feed.push(newsfeedChallenge);
    feed.push(newsfeedChallenge);

    return of(feed);

  }
}
