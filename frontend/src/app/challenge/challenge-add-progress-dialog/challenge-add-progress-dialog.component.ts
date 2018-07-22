import {Component, Inject} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material";
import {ChallengeComponent} from "../challenge.component";
import {ChallengeProgress} from "../challenge";

@Component({
  selector: 'app-challenge-add-progress-dialog',
  templateUrl: './challenge-add-progress-dialog.component.html',
  styleUrls: ['./challenge-add-progress-dialog.component.css']
})
export class ChallengeAddProgressDialogComponent {

  constructor(
    public dialogRef: MatDialogRef<ChallengeComponent>,
    @Inject(MAT_DIALOG_DATA) public data: ChallengeProgress) {
  }

  onNoClick(): void {
    this.dialogRef.close();
  }

}

/*
@Component({
  selector: 'dialog-overview-example-dialog',
  templateUrl: 'dialog-overview-example-dialog.html',
})
export class DialogOverviewExampleDialog {

  constructor(
    public dialogRef: MatDialogRef<DialogOverviewExampleDialog>,
    @Inject(MAT_DIALOG_DATA) public data: DialogData) {}

  onNoClick(): void {
    this.dialogRef.close();
  }

}

 */
