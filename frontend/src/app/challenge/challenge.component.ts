import {Component, Input, OnInit} from '@angular/core';
import {Challenge} from "./challenge";
import {ActivatedRoute} from "@angular/router";
import {ChallengeService} from "./challenge.service";

@Component({
  selector: 'app-challenge',
  templateUrl: './challenge.component.html',
  styleUrls: ['./challenge.component.css']
})
export class ChallengeComponent implements OnInit {

  challenge: Challenge;

  constructor(private route: ActivatedRoute,
              private challengeService: ChallengeService) { }

  ngOnInit() {
    this.challenge = new Challenge();
    const id = this.route.snapshot.paramMap.get('id');

    this.challengeService.getChallenges().subscribe((result) => {

    });
  }

}
