import { Component, OnInit } from '@angular/core';
import {NewsfeedService} from "./newsfeed.service";

@Component({
  selector: 'app-newsfeed',
  templateUrl: './newsfeed.component.html',
  styleUrls: ['./newsfeed.component.css']
})
export class NewsfeedComponent implements OnInit {

  newsfeedItems = [];

  constructor(private newsfeedService: NewsfeedService) { }

  ngOnInit() {
    this.newsfeedService.getNewsfeed().subscribe((result) => {
      this.newsfeedItems = result;
    });
  }
}
