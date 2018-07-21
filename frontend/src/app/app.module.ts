import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import {BrowserAnimationsModule} from '@angular/platform-browser/animations';

import {MatButtonModule, MatToolbarModule, MatSidenavModule, MatIconModule, MatListModule, MatFormFieldModule, MatInputModule} from '@angular/material';

import { AppComponent } from './app.component';
import { LayoutModule } from '@angular/cdk/layout';
import { NavbarComponent } from './navbar/navbar.component';
import { AuthenticationComponent } from './login/authentication/authentication.component';
import { CredentialsComponent } from './login/credentials/credentials.component';
import { AuthenticationActionsComponent } from './login/authentication-actions/authentication-actions.component';
import { LoginComponent } from './login/login.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    AuthenticationComponent,
    CredentialsComponent,
    AuthenticationActionsComponent,
    LoginComponent
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
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
