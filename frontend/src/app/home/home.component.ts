import { Component, OnInit } from '@angular/core';
import {Challenge} from "../challenge/challenge";
import {ChallengeService} from "../challenge/challenge.service";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  entries: Challenge[] = [];

  constructor(private challengeService: ChallengeService) { }

  ngOnInit() {
    this.challengeService.getChallenges().subscribe((challenges) => {
      challenges.forEach(challenge => {
        challenge.endDate = new Date(challenge.endDate);
      });
      this.entries = challenges;
    });
  }

}
