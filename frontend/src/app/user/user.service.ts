import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  currentUserId = 1;

  constructor() { }

  public getCurrentUserId() {
    return this.currentUserId;
  }

  public setCurrentUserId(userId: number): void {
    this.currentUserId = userId;
  }
}
