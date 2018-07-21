import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { FormsModule } from '@angular/forms';
import {MatCardModule, MatButtonModule, MatToolbarModule, MatSidenavModule, MatIconModule, MatListModule, MatFormFieldModule, MatInputModule} from '@angular/material';

import { AppComponent } from './app.component';
import { LayoutModule } from '@angular/cdk/layout';
import { NavbarComponent } from './navbar/navbar.component';
import { AuthenticationComponent } from './login/authentication/authentication.component';
import { CredentialsComponent } from './login/credentials/credentials.component';
import { AuthenticationActionsComponent } from './login/authentication-actions/authentication-actions.component';
import { LoginComponent } from './login/login.component';
import { ChallengeWizardComponent } from './challenge-wizard/challenge-wizard.component';
import { ChallengeWizardActionsComponent } from './challenge-wizard/challenge-wizard-actions/challenge-wizard-actions.component';
import { ChallengeWizardDataComponent } from './challenge-wizard/challenge-wizard-data/challenge-wizard-data.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    AuthenticationComponent,
    CredentialsComponent,
    AuthenticationActionsComponent,
    LoginComponent,
    ChallengeWizardComponent,
    ChallengeWizardActionsComponent,
    ChallengeWizardDataComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    HttpClientModule,
    MatButtonModule,
    LayoutModule,
    MatToolbarModule,
    MatSidenavModule,
    MatIconModule,
    MatListModule,
    MatFormFieldModule,
    MatInputModule,
    FormsModule,
    MatCardModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
