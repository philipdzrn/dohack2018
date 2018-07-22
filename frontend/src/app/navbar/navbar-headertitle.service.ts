import {Injectable, OnInit} from '@angular/core';
import {Observable} from "rxjs/Observable";
import {Subject} from "rxjs/Subject";

@Injectable({
  providedIn: 'root'
})
export class NavbarHeadertitleService implements OnInit {

  headerTitle: string = "";
  headerTitleObservable = new Subject<any>();

  constructor() { }

  ngOnInit() {

  }

  public getMessage(): Observable<any> {
    return this.headerTitleObservable.asObservable();
  }

  public setHeaderTitle(title: string): void {
    this.headerTitleObservable.next({ text: title });
  }
}
