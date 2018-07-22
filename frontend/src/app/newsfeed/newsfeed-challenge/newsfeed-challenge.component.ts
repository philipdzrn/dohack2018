import {Component, Input, OnInit} from '@angular/core';
import {Challenge} from "../../challenge/challenge";
import {NewsfeedChallenge} from "../newsfeed-challenge";

@Component({
  selector: 'app-newsfeed-challenge',
  templateUrl: './newsfeed-challenge.component.html',
  styleUrls: ['./newsfeed-challenge.component.css']
})
export class NewsfeedChallengeComponent implements OnInit {

  @Input()
  newsfeedChallenge: Challenge;

  @Input()
  likesNumber:NewsfeedChallenge;


  constructor() { }

  ngOnInit() {
  }

}
