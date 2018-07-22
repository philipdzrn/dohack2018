import { Component, OnInit } from '@angular/core';
import {Challenge} from "../challenge/challenge";
import {ChallengeService} from "../challenge/challenge.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-challenge-wizard',
  templateUrl: './challenge-wizard.component.html',
  styleUrls: ['./challenge-wizard.component.css']
})
export class ChallengeWizardComponent implements OnInit {

  challenge: Challenge;

  constructor(private challengeService: ChallengeService,
              private router: Router) { }

  ngOnInit() {
    this.challenge = new Challenge();
  }

  public onSubmit() {

    this.challengeService.createChallenge(this.challenge).subscribe(() => {
      this.router.navigate(['home']);
    });
  }

  public onCancel() {
    this.challenge = new Challenge();
  }

  public onChallengeChange($event) {

  }

}
