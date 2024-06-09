import {Component, OnInit} from '@angular/core';
import {environment} from "../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Annonce} from "../interfaces/annonce";
import {AnnonceService} from "../services/annonce.service";
import {PageEvent} from "@angular/material/paginator";
import {DialogserviceService} from "../services/dialogservice.service";

@Component({
  selector: 'app-annonce',
  templateUrl: './annonce.component.html',
  styleUrl: './annonce.component.css'
})
export class AnnonceComponent implements OnInit{
  annonces: Annonce[] = [];
  pageIndex: number = 0;
  pageSize: number = 7;
  length: number = 0;
  selectedAnnonce: any = null;
  constructor(private annonceService: AnnonceService, private dialogService: DialogserviceService) {
  }

  ngOnInit(): void {
    this.getAnnounces();
  }

  getAnnounces() {
    this.annonceService.getAnnonces(this.pageIndex, this.pageSize).subscribe(
      (data) => {
        this.annonces = data.content;
        this.length = data.totalElements;
      }
    );
  }

  nextPage(): void {
    if (this.pageIndex < this.length - 1) {
      this.pageIndex++;
      this.getAnnounces();
    }
  }

  previousPage(): void {
    if (this.pageIndex > 0) {
      this.pageIndex--;
      this.getAnnounces();
    }
  }

  onPageChange(event: PageEvent) {
    this.pageIndex = event.pageIndex;
    this.pageSize = event.pageSize;
    this.getAnnounces();
  }

  openPopup(annonce: any): void {
    this.selectedAnnonce = annonce;
  }

  closePopup(): void {
    this.selectedAnnonce = null;
  }
  openDetail(annonce: Annonce) {
    this.dialogService.openDetailDialog(annonce);
  }

}
