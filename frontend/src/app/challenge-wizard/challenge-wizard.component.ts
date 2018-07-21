import { Component, OnInit } from '@angular/core';
import {Challenge} from "../challenge/challenge";
import {ChallengeService} from "../challenge/challenge.service";

@Component({
  selector: 'app-challenge-wizard',
  templateUrl: './challenge-wizard.component.html',
  styleUrls: ['./challenge-wizard.component.css']
})
export class ChallengeWizardComponent implements OnInit {

  challenge: Challenge;

  constructor(private challengeService: ChallengeService) { }

  ngOnInit() {
    this.challenge = new Challenge();
  }

  public onSubmit() {

    this.challengeService.createChallenge(this.challenge).subscribe();
  }

  public onCancel() {
    this.challenge = new Challenge();
  }

  public onChallengeChange($event) {

  }

}
