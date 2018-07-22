import {Component, Input, OnInit} from '@angular/core';
import {Challenge} from "./challenge";
import {ActivatedRoute} from "@angular/router";
import {ChallengeService} from "./challenge.service";
import {ChallengeAddProgressDialogComponent} from "./challenge-add-progress-dialog/challenge-add-progress-dialog.component";
import {MatDialog} from "@angular/material";

@Component({
  selector: 'app-challenge',
  templateUrl: './challenge.component.html',
  styleUrls: ['./challenge.component.css']
})
export class ChallengeComponent implements OnInit {

  challenge: Challenge;

  constructor(private route: ActivatedRoute,
              private challengeService: ChallengeService,
              private dialog: MatDialog) {
  }

  ngOnInit() {
    this.challenge = new Challenge();
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
}
