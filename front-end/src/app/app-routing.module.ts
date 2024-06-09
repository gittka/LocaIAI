import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {HomeComponent} from "./home/home.component";
import {AdminComponent} from "./admin/admin.component";
import {UtilisateurComponent} from "./utilisateur/utilisateur.component";
import {AnnonceComponent} from "./annonce/annonce.component";
import {ReservationComponent} from "./reservation/reservation.component";

const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: '', component: HomeComponent },
  { path: 'admin', component: AdminComponent },
  {path:'utilisateurs', component: UtilisateurComponent},
  { path: 'annonces', component: AnnonceComponent },
  { path: 'reservations', component: ReservationComponent }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
