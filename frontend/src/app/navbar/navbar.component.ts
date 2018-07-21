import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  headertitle: string = "Newsfeed";

  constructor() {
  }

  ngOnInit() {
  }

  public onNavigate(title: string): void {
    this.headertitle = title;
  }

}
