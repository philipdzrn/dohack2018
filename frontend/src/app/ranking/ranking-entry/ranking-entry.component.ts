import {Component, Input, OnInit} from '@angular/core';
import {Ranking} from "../ranking";

@Component({
  selector: 'app-ranking-entry',
  templateUrl: './ranking-entry.component.html',
  styleUrls: ['./ranking-entry.component.css']
})
export class RankingEntryComponent implements OnInit {

  @Input()
  rankingEntry: Ranking;

  constructor() { }

  ngOnInit() {
  }

}
