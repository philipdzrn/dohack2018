import {Component, OnInit} from '@angular/core';
import {NavbarHeadertitleService} from "./navbar-headertitle.service";

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  headertitle: string = "Newsfeed";

  constructor(private navbarHeadertitleService: NavbarHeadertitleService) {
  }

  ngOnInit() {
    this.navbarHeadertitleService.getMessage().subscribe((title) => {
      this.headertitle = title;
    });
  }


  public onNavigate(title: string): void {
    this.headertitle = title;
  }
  
}
