import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ChallengeWizardActionsComponent } from './challenge-wizard-actions.component';

describe('ChallengeWizardActionsComponent', () => {
  let component: ChallengeWizardActionsComponent;
  let fixture: ComponentFixture<ChallengeWizardActionsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ChallengeWizardActionsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ChallengeWizardActionsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
