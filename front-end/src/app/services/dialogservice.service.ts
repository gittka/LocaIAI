import {Injectable} from '@angular/core';
import {MatDialog} from "@angular/material/dialog";
import {AnnonceDetailComponent} from "../annonce-detail/annonce-detail.component";
import {Annonce} from "../interfaces/annonce";

@Injectable({
  providedIn: 'root'
})
export class DialogserviceService {

  constructor(private dialog: MatDialog) {
  }

  openDetailDialog(annonce: Annonce) {
    this.dialog.open(AnnonceDetailComponent, {
      width: '400px',
      data: annonce
    });
  }
}
