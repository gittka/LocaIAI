import {Component, OnInit} from '@angular/core';
import {UtilisateurService} from "../services/utilisateur.service";
import {User} from "../interfaces/utilisateur";
import {HttpErrorResponse} from "@angular/common/http";
import {MatDialog} from "@angular/material/dialog";
import {EdituserComponent} from "../edituser/edituser.component";
import {DeleteuserComponent} from "../deleteuser/deleteuser.component";
import {DetailsuserComponent} from "../detailsuser/detailsuser.component";

@Component({
  selector: 'app-utilisateur',
  templateUrl: './utilisateur.component.html',
  styleUrl: './utilisateur.component.css'
})
export class UtilisateurComponent implements OnInit {
  utilisateurs: User[] = [];

  constructor(private utilisateurService: UtilisateurService, public dialog: MatDialog) {
  }

  ngOnInit(): void {
    this.getUtilisateurs();
  }

  public getUtilisateurs(): void {
    this.utilisateurService.getAllUtilisateur().subscribe(
      data => {
        this.utilisateurs = data
      }, (error: HttpErrorResponse) => {
        alert(error.message);
        console.log(error.message);
      }
    );
  }

  public deleteUtilisateur(id: number): void {
    this.utilisateurService.deleteUtilisateur(id).subscribe(
      (data) => {
        this.getUtilisateurs();
      }, (error: HttpErrorResponse) => {
        alert(error.message);
        console.log(error.message);
      }
    );
  }

  editUtilisateur(utilisateur: User): void {
    this.utilisateurService.updateUtilisateur(utilisateur).subscribe(
      (data) => {
        this.getUtilisateurs();
      }, (error: HttpErrorResponse) => {
        alert(error.message);
        console.log(error.message);
      }
    );
  }

  openEditUserDialog(utilisateur: User): void {
    const dialogRef = this.dialog.open(EdituserComponent, {
      width: '800px',
      data: utilisateur
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.utilisateurService.updateUtilisateur(result).subscribe(data => {
            this.getUtilisateurs();
          });
      }
    });
  }

  openDeleteUserDialog(id: number): void {
    const dialogRef = this.dialog.open(DeleteuserComponent, {
      width: '300px',
      data: id
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.utilisateurService.deleteUtilisateur(result.id).subscribe(data => {
          this.getUtilisateurs();
        });
      }
    });
  }

  openDetailsDialog(user: User): void {
    this.dialog.open(DetailsuserComponent, {
      width: '300px',
      data: user
    });
  }
}
