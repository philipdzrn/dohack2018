import { Component, OnInit } from '@angular/core';
import {Challenge} from "../challenge/challenge";

@Component({
  selector: 'app-challenge-wizard',
  templateUrl: './challenge-wizard.component.html',
  styleUrls: ['./challenge-wizard.component.css']
})
export class ChallengeWizardComponent implements OnInit {

  challenge: Challenge;

  constructor() { }

  ngOnInit() {
    this.challenge = new Challenge();
  }

  public onSubmit() {

  }

  public onCancel() {
    this.challenge = new Challenge();
  }

  public onChallengeChange($event) {

  }

}
