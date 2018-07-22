import {Component, Input, OnInit} from '@angular/core';
import {Challenge, LikeByChallenge} from "../../challenge/challenge";
import {NewsfeedChallenge} from "../newsfeed-challenge";
import {ChallengeService} from "../../challenge/challenge.service";

@Component({
  selector: 'app-newsfeed-challenge',
  templateUrl: './newsfeed-challenge.component.html',
  styleUrls: ['./newsfeed-challenge.component.css']
})
export class NewsfeedChallengeComponent implements OnInit {

  @Input()
  newsfeedChallenge: Challenge;

  likesNumber:number;

  likeDisabled: boolean = false;

  constructor(private challengeService: ChallengeService) { }

  ngOnInit() {
    if(this.newsfeedChallenge) {
      this.loadChallenge();
    }
  }

  public incLike() {

    this.likeDisabled = true;
    this.challengeService.likeChallenge(this.newsfeedChallenge.id).subscribe(() => {
      this.loadChallenge();
    });
  }

  private loadChallenge() {
    this.challengeService.getLikesByChallenge(this.newsfeedChallenge.id).subscribe((result: LikeByChallenge) => {
      this.likesNumber = result.likeCount;
      this.likeDisabled = result.currentUserLikedChallenge;
    });
  }

}
