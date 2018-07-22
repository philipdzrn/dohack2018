import { Component, OnInit } from '@angular/core';
import {Challenge} from "../../challenge/challenge";

@Component({
  selector: 'app-home-entry',
  templateUrl: './home-entry.component.html',
  styleUrls: ['./home-entry.component.css']
})
export class HomeEntryComponent implements OnInit {

  challenge:Challenge;

  constructor() { }

  ngOnInit() {
  }

}
