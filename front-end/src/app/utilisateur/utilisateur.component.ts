import {Component, OnInit} from '@angular/core';
import {UtilisateurService} from "../services/utilisateur.service";
import {User} from "../interfaces/utilisateur";
import {HttpErrorResponse} from "@angular/common/http";

@Component({
  selector: 'app-utilisateur',
  templateUrl: './utilisateur.component.html',
  styleUrl: './utilisateur.component.css'
})
export class UtilisateurComponent implements OnInit{
  utilisateurs: User[] = [];
  constructor(private utilisateurService: UtilisateurService) {
  }
  ngOnInit(): void {
    this.getUtilisateurs();
  }

  public getUtilisateurs(): void {
    this.utilisateurService.getAllUtilisateur().subscribe(
      data  => {
        this.utilisateurs = data
      },(error: HttpErrorResponse)  => {
        alert(error.message);
        console.log(error.message);
      }
    );
  }
}
