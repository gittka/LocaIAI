import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { AnnonceComponent } from './annonce/annonce.component';
import { UtilisateurComponent } from './utilisateur/utilisateur.component';
import { LogementComponent } from './logement/logement.component';
import { ReservationComponent } from './reservation/reservation.component';
import {NgOptimizedImage} from "@angular/common";
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { AdminComponent } from './admin/admin.component';
import {HttpClientModule} from "@angular/common/http";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';
import {MatFormField, MatLabel} from "@angular/material/form-field";
import {MatOption} from "@angular/material/autocomplete";
import {MatSelect} from "@angular/material/select";
import {MatIcon} from "@angular/material/icon";
import {MatCard, MatCardContent, MatCardImage} from "@angular/material/card";
import {MatPaginator} from "@angular/material/paginator";
import {AnnonceDetailComponent} from "./annonce-detail/annonce-detail.component";
import {MatButton} from "@angular/material/button";
import { PopupComponent } from './popup/popup.component';
import { EdituserComponent } from './edituser/edituser.component';
import { DeleteuserComponent } from './deleteuser/deleteuser.component';
import { DetailsuserComponent } from './detailsuser/detailsuser.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    AnnonceComponent,
    UtilisateurComponent,
    LogementComponent,
    ReservationComponent,
    HeaderComponent,
    FooterComponent,
    AdminComponent,
    AnnonceDetailComponent,
    PopupComponent,
    EdituserComponent,
    DeleteuserComponent,
    DetailsuserComponent
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        NgOptimizedImage,
        HttpClientModule,
        ReactiveFormsModule,
        MatLabel,
        MatFormField,
        MatOption,
        MatSelect,
        FormsModule,
        MatIcon,
        MatCardContent,
        MatCard,
        MatPaginator,
        MatCardImage,
        MatButton
    ],
  providers: [
    provideAnimationsAsync()
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
