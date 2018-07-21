import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {UserService} from "../user/user.service";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ChallengeService {

  constructor(private httpClient: HttpClient,
              private userService: UserService) { }

  public getChallenges(): Observable<any> {
    let userId = this.userService.currentUserId;

    let url = 'http://localhost:8090/challenges/' + userId;

    return this.httpClient.get(url);
  }
}
