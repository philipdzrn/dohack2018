import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-authentication-actions',
  templateUrl: './authentication-actions.component.html',
  styleUrls: ['./authentication-actions.component.css']
})
export class AuthenticationActionsComponent implements OnInit {

  isSignUpModeActive: boolean;

  constructor() { }

  ngOnInit() {
  }

  public submit(): void {
    alert("submit");
  }

  public switchMode() {
    this.isSignUpModeActive = !this.isSignUpModeActive;
  }

}
