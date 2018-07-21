import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {UserCredentials} from "../user-credentials";

@Component({
  selector: 'app-credentials',
  templateUrl: './credentials.component.html',
  styleUrls: ['./credentials.component.css']
})
export class CredentialsComponent implements OnInit {

  credentials: UserCredentials;

  @Output() credentialsChanged = new EventEmitter();

  constructor() {
  }

  ngOnInit() {
    this.credentials = new UserCredentials();
  }

  public credentialsOnChange() {
    if (this.credentials.username && this.credentials.password) {
      this.credentialsChanged.emit(this.credentials);
    }
  }
}
