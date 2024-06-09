import {Component, Inject} from '@angular/core';
import {MAT_DIALOG_DATA} from "@angular/material/dialog";
import {Annonce} from "../interfaces/annonce";

@Component({
  selector: 'app-annonce-detail',
  templateUrl: './annonce-detail.component.html',
  styleUrl: './annonce-detail.component.css'
})
export class AnnonceDetailComponent {
  constructor(@Inject(MAT_DIALOG_DATA) public data: Annonce) {
  }

}
