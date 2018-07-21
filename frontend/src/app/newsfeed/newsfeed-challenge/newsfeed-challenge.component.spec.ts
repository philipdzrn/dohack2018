import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NewsfeedChallengeComponent } from './newsfeed-challenge.component';

describe('NewsfeedChallengeComponent', () => {
  let component: NewsfeedChallengeComponent;
  let fixture: ComponentFixture<NewsfeedChallengeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NewsfeedChallengeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NewsfeedChallengeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
