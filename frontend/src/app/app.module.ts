import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {HttpClientModule} from '@angular/common/http';

import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {FormsModule} from '@angular/forms';
import {
  MatNativeDateModule,
  MatDatepickerModule,
  MatCardModule,
  MatButtonModule,
  MatToolbarModule,
  MatSidenavModule,
  MatIconModule,
  MatListModule,
  MatFormFieldModule,
  MatInputModule,
  MatMenuModule
} from '@angular/material';

import {AppComponent} from './app.component';
import {LayoutModule} from '@angular/cdk/layout';
import {NavbarComponent} from './navbar/navbar.component';
import {AuthenticationComponent} from './login/authentication/authentication.component';
import {CredentialsComponent} from './login/credentials/credentials.component';
import {AuthenticationActionsComponent} from './login/authentication-actions/authentication-actions.component';
import {LoginComponent} from './login/login.component';
import {ChallengeWizardComponent} from './challenge-wizard/challenge-wizard.component';
import {ChallengeWizardActionsComponent} from './challenge-wizard/challenge-wizard-actions/challenge-wizard-actions.component';
import {ChallengeWizardDataComponent} from './challenge-wizard/challenge-wizard-data/challenge-wizard-data.component';
import {NewsfeedComponent} from './newsfeed/newsfeed.component';
import {NewsfeedChallengeComponent} from './newsfeed/newsfeed-challenge/newsfeed-challenge.component';
import {RouterModule, Routes} from "@angular/router";

const appRoutes: Routes = [
  { path: '', component: NewsfeedComponent },
  // { path: '/:id',      component: HeroDetailComponent },
  /*
  {
    path: 'heroes',
    component: HeroListComponent,
    data: { title: 'Heroes List' }
  },
  { path: '',
    redirectTo: '/heroes',
    pathMatch: 'full'
  },
  { path: '**', component: PageNotFoundComponent }
  */
];

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
    ChallengeWizardDataComponent,
    NewsfeedComponent,
    NewsfeedChallengeComponent
  ],
  imports: [
    RouterModule.forRoot(
      appRoutes,
      {enableTracing: true}
    ),
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
    MatDatepickerModule,
    MatNativeDateModule,
    MatMenuModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
