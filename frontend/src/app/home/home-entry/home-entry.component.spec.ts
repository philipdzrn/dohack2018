import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HomeEntryComponent } from './home-entry.component';

describe('HomeEntryComponent', () => {
  let component: HomeEntryComponent;
  let fixture: ComponentFixture<HomeEntryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HomeEntryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HomeEntryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
