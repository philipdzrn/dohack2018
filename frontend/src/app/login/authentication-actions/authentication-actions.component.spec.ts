import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AuthenticationActionsComponent } from './authentication-actions.component';

describe('AuthenticationActionsComponent', () => {
  let component: AuthenticationActionsComponent;
  let fixture: ComponentFixture<AuthenticationActionsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AuthenticationActionsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AuthenticationActionsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
