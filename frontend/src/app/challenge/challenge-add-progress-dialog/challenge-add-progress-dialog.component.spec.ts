import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ChallengeAddProgressDialogComponent } from './challenge-add-progress-dialog.component';

describe('ChallengeAddProgressDialogComponent', () => {
  let component: ChallengeAddProgressDialogComponent;
  let fixture: ComponentFixture<ChallengeAddProgressDialogComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ChallengeAddProgressDialogComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ChallengeAddProgressDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
