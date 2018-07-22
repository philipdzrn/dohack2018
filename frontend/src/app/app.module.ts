import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';

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
  MatMenuModule,
  MatDialogModule,
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
import {RankingComponent} from './ranking/ranking.component';
import {RankingEntryComponent} from './ranking/ranking-entry/ranking-entry.component';
import {ChallengeComponent} from './challenge/challenge.component';
import {ProfileComponent} from './profile/profile.component';
import {UserIdInterceptor} from "./utils/user-id-interceptor";
import {HomeComponent} from './home/home.component';
import {HomeEntryComponent} from './home/home-entry/home-entry.component';
import {ChallengeAddProgressDialogComponent} from './challenge/challenge-add-progress-dialog/challenge-add-progress-dialog.component';

const appRoutes: Routes = [
  {path: 'newsfeed', component: NewsfeedComponent},
  {path: 'challenge/create', component: ChallengeWizardComponent},
  {path: 'ranking', component: RankingComponent},
  {path: 'challenge/:id', component: ChallengeComponent},
  {path: 'profile/:id', component: ProfileComponent},
  {path: 'home', component: HomeComponent},
  {
    path: '',
    redirectTo: '/home',
    pathMatch: 'full'
  },

  /*
  {
    path: 'heroes',
    component: HeroListComponent,
    data: { title: 'Heroes List' }
  },
  { path: '',
    redirectTo: '/newsfeed',
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
    NewsfeedChallengeComponent,
    RankingComponent,
    RankingEntryComponent,
    ChallengeComponent,
    ProfileComponent,
    HomeComponent,
    HomeEntryComponent,
    ChallengeAddProgressDialogComponent,
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
    MatMenuModule,
    MatDialogModule
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: UserIdInterceptor,
      multi: true
    }
  ],
  entryComponents: [
    ChallengeAddProgressDialogComponent
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
