import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {Challenge} from "../../challenge/challenge";

@Component({
  selector: 'app-challenge-wizard-data',
  templateUrl: './challenge-wizard-data.component.html',
  styleUrls: ['./challenge-wizard-data.component.css']
})
export class ChallengeWizardDataComponent implements OnInit {

  newUserChallenge: Challenge;

  @Output() newUserChallengeChanged = new EventEmitter();

  constructor() {
  }

  ngOnInit() {
    this.newUserChallenge = new Challenge();
  }

  public challengeCreateOnChange() {
    if (this.newUserChallenge.name && this.newUserChallenge.description && this.newUserChallenge.endDate && this.newUserChallenge.goal)
      this.newUserChallengeChanged.emit(this.newUserChallenge);
  }
}
