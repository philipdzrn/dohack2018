import { Component, OnInit } from '@angular/core';
import {User} from "../login/user";

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  userprofile: User;

  constructor() { }

  ngOnInit() {
  }

}
