import {Component} from '@angular/core';
import {ChallengeService} from "./challenge/challenge.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  constructor(private challengeService: ChallengeService) {
  }

  title = "";

  testOnClick(): void {
    this.challengeService.getChallenges().subscribe((result) => {
      console.dir(result);
      this.title = result.message;
    });
  }
}
