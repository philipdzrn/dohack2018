import {Component, Input, OnInit} from '@angular/core';
import {Challenge} from "./challenge";
import {ActivatedRoute} from "@angular/router";
import {ChallengeService} from "./challenge.service";
import {ChallengeAddProgressDialogComponent} from "./challenge-add-progress-dialog/challenge-add-progress-dialog.component";
import {MatDialog} from "@angular/material";
import {AuthenticationService} from "../login/authentication.service";
import {User} from "../login/user";

@Component({
  selector: 'app-challenge',
  templateUrl: './challenge.component.html',
  styleUrls: ['./challenge.component.css']
})
export class ChallengeComponent implements OnInit {

  challenge: Challenge;

  constructor(private route: ActivatedRoute,
              private challengeService: ChallengeService,
              private authenticationService: AuthenticationService,
              private dialog: MatDialog) {
  }

  ngOnInit() {
    this.challenge = new Challenge();
    this.challenge.creator = new User();
    this.challenge.creator.id = -1;
    const id = this.route.snapshot.paramMap.get('id');

    this.loadChallenge(id);
  }

  public addProgressButtonClicked(): void {
    const dialogRef = this.dialog.open(ChallengeAddProgressDialogComponent, {
      width: '300px',
      data: {value: this.challenge.currentValue}
    });

    dialogRef.afterClosed().subscribe(result => {
      this.challengeService.updateChallenge(this.challenge.id, result).subscribe(() => {
        console.dir("done");
        this.loadChallenge(this.challenge.id + "");
      });
    });
  }

  private loadChallenge(id: string): void {
    this.challengeService.getChallenge(id).subscribe((result) => {
      result.endDate = new Date(result.endDate);
      this.challenge = result;
    });
  }

  public challengeBelongsToCurrentUser(): boolean {

    if(!this.challenge) {
      return false;
    }
    return this.authenticationService.getCurrentUserId() == (this.challenge.creator.id + "");
  }
}
