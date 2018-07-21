import {Component, OnInit} from '@angular/core';
import {User} from "../login/user";
import {UserService} from "./user.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  userProfile: User;

  constructor(private route: ActivatedRoute,
              private userService: UserService) {
  }

  ngOnInit() {
    this.userProfile = new User();
    const id = this.route.snapshot.paramMap.get('id');
    this.userService.getUser(id).subscribe((result) => {
      this.userProfile = result;
    });

  }
}
