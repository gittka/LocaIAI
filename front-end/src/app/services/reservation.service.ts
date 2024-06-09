import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Reservation} from "../interfaces/reservation";

@Injectable({
  providedIn: 'root'
})
export class ReservationService {
  private serverUrl: string = 'http://localhost:8080';

  constructor(private httpClient: HttpClient) { }

  getAllReservations(page: number, size: number): Observable<Reservation[]> {
    return this.httpClient.get<Reservation[]>(`${this.serverUrl}/reservation?page=${page}&size=${size}`);
  }
}
