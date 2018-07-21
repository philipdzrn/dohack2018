import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  currentUserId: number;

  constructor() { }

  public getCurrentUserId() {
    return this.currentUserId;
  }

  public setCurrentUserId(userId: number): void {
    this.currentUserId = userId;
  }
}
