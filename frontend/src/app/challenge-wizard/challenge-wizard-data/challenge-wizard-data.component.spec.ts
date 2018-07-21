import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ChallengeWizardDataComponent } from './challenge-wizard-data.component';

describe('ChallengeWizardDataComponent', () => {
  let component: ChallengeWizardDataComponent;
  let fixture: ComponentFixture<ChallengeWizardDataComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ChallengeWizardDataComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ChallengeWizardDataComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
