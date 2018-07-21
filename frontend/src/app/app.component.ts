import {Component} from '@angular/core';
import {AuthenticationService} from "./login/authentication.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  constructor(private authenticationService: AuthenticationService) {
  }

  public userIsAuthenticated(): boolean {
    return !!this.authenticationService.getCurrentUserId();
  }
}
