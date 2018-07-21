import { Component, OnInit } from '@angular/core';
import {AuthenticationService} from "../authentication.service";

@Component({
  selector: 'app-authentication-actions',
  templateUrl: './authentication-actions.component.html',
  styleUrls: ['./authentication-actions.component.css']
})
export class AuthenticationActionsComponent implements OnInit {

  isSignUpModeActive: boolean;

  constructor(private authenticationService:AuthenticationService) {
  }

  ngOnInit() {
  }

  public submit(): void {
    this.isSignUpModeActive ? this.authenticationService.register() : this.authenticationService.login();
  }

  public switchMode() {
    this.isSignUpModeActive = !this.isSignUpModeActive;
  }

}
