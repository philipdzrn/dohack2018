import {Component, Input, OnInit} from '@angular/core';
import {Challenge} from "../../challenge/challenge";

@Component({
  selector: 'app-newsfeed-challenge',
  templateUrl: './newsfeed-challenge.component.html',
  styleUrls: ['./newsfeed-challenge.component.css']
})
export class NewsfeedChallengeComponent implements OnInit {

  @Input()
  newsfeedChallenge: Challenge;

  constructor() { }

  ngOnInit() {
  }

}
