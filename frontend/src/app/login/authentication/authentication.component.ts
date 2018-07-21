import {Component, OnInit} from '@angular/core';
import {UserCredentials} from "../user-credentials";
import {AuthenticationService} from "../authentication.service";

@Component({
  selector: 'app-authentication',
  templateUrl: './authentication.component.html',
  styleUrls: ['./authentication.component.css']
})
export class AuthenticationComponent implements OnInit {

  credentials: UserCredentials;

  constructor(private authenticationService: AuthenticationService) {
  }

  ngOnInit() {
  }

  public credentialsOnChange($event: UserCredentials): void {
    console.dir($event);
    if($event) {
      this.credentials = $event;
    }
  }

  public login(): void {

    console.dir(this.credentials);
    if(this.credentials) {
      this.authenticationService.login(this.credentials);
    }

  }

  public register(): void {
    if(this.credentials) {
      this.authenticationService.register(this.credentials);
    }
  }

}
