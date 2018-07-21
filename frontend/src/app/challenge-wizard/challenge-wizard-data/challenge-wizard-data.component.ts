import {Component, EventEmitter, Input, OnChanges, OnInit, Output} from '@angular/core';
import {Challenge} from "../../challenge/challenge";

@Component({
  selector: 'app-challenge-wizard-data',
  templateUrl: './challenge-wizard-data.component.html',
  styleUrls: ['./challenge-wizard-data.component.css']
})
export class ChallengeWizardDataComponent implements OnInit {

  @Input()
  challenge: Challenge;

  @Output() challengeChanged = new EventEmitter();

  constructor() {
  }

  ngOnInit() {
  }

  public challengeCreateOnChange() {
    if (this.challenge.name && this.challenge.description && this.challenge.end && this.challenge.goal)
      this.challengeChanged.emit(this.challenge);
  }
}
