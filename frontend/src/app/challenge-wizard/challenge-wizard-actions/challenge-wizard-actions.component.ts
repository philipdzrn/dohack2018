import {Component, EventEmitter, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-challenge-wizard-actions',
  templateUrl: './challenge-wizard-actions.component.html',
  styleUrls: ['./challenge-wizard-actions.component.css']
})
export class ChallengeWizardActionsComponent implements OnInit {

  @Output() submitted = new EventEmitter();
  @Output() cancelled = new EventEmitter();

  constructor() {
  }

  ngOnInit() {
  }

  public submit() {
    this.submitted.emit();
  }

  public cancel() {
    this.cancelled.emit();
  }

}
