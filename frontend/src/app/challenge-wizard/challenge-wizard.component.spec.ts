import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ChallengeWizardComponent } from './challenge-wizard.component';

describe('ChallengeWizardComponent', () => {
  let component: ChallengeWizardComponent;
  let fixture: ComponentFixture<ChallengeWizardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ChallengeWizardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ChallengeWizardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
