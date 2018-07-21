import {Component, OnInit} from '@angular/core';
import {RankingService} from "./ranking.service";

@Component({
  selector: 'app-ranking',
  templateUrl: './ranking.component.html',
  styleUrls: ['./ranking.component.css']
})
export class RankingComponent implements OnInit {

  rankingItems = [];

  constructor(private rankingService: RankingService) {
  }


  ngOnInit() {
    this.rankingService.getRankings().subscribe((result) => {
      this.rankingItems = result;
    });
  }
}
