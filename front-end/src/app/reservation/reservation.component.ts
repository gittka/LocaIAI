import {Component, OnInit} from '@angular/core';
import {ReservationService} from "../services/reservation.service";
import {Reservation} from "../interfaces/reservation";

@Component({
  selector: 'app-reservation',
  templateUrl: './reservation.component.html',
  styleUrl: './reservation.component.css'
})
export class ReservationComponent {
 /* reservations: Reservation[] = [];
  page: number = 1;
  size: number = 10;
  length: number = 0;
  constructor(private reservationService: ReservationService) {
  }

  ngOnInit(): void {
  }
  getReservations(): void {
    this.reservationService.getAllReservations(this.page,this.size).subscribe(
      (data)  => {
        this.reservations = data.content;
        this.length = data.totalElements;
      }
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
  }*/

}
