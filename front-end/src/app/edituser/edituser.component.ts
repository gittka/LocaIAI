import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialog, MatDialogRef} from "@angular/material/dialog";
import {HttpClient} from "@angular/common/http";
import {UtilisateurService} from "../services/utilisateur.service";

@Component({
  selector: 'app-edituser',
  templateUrl: './edituser.component.html',
  styleUrl: './edituser.component.css'
})
export class EdituserComponent implements OnInit{

  userTypes : string[] = [];
  hidePassword: boolean = true;

  constructor(private utilsaurService: UtilisateurService, private http : HttpClient, public dialogRef: MatDialogRef<EdituserComponent>,
              @Inject(MAT_DIALOG_DATA) public data: any) {
  }
  ngOnInit(): void {
    this.findUserType()
  }


  findUserType(): void {
    this.http.get<string[]>('http://localhost:8080/types').subscribe(
      (types) => {
        this.userTypes = types;
      },
      (error) => {
        console.log(error);
      }
    )
  }

  onSave(): void {
    console.log(this.data)
    // save the user
    /*this.utilsaurService.updateUtilisateur(this.data).subscribe(
      next => () => this.dialogRef.close(),
      error => {
            alert(error.message);
            console.log(error.message);
          });*/
    this.utilsaurService.updateUtilisateur(this.data)
    this.dialogRef.close(this.data)
      }


  onCancel(): void {
    this.dialogRef.close();
  }

  togglePasswordVisibility(): void {
    this.hidePassword = !this.hidePassword;
  }
}
