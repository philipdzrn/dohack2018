import {Component, EventEmitter, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-authentication-actions',
  templateUrl: './authentication-actions.component.html',
  styleUrls: ['./authentication-actions.component.css']
})
export class AuthenticationActionsComponent implements OnInit {

  isSignUpModeActive: boolean;

  @Output() onLogin = new EventEmitter();
  @Output() onRegister = new EventEmitter();

  @Output() onModeChanged = new EventEmitter();

  constructor() {
  }

  ngOnInit() {
  }

  public submit(): void {
    this.isSignUpModeActive ? this.onLogin.emit() : this.onRegister.emit();
  }

  public switchMode() {
    this.isSignUpModeActive = !this.isSignUpModeActive;
    this.onModeChanged.emit(this.isSignUpModeActive);
  }
}
