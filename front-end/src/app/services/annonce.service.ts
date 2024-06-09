import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class AnnonceService {
  private urlServer = "http://localhost:8080";

  constructor(private httpClient: HttpClient) { }

  getAnnonces(page: number, size: number): Observable<any> {
    return this.httpClient.get<any>(`${this.urlServer}/annonces?page=${page}&size=${size}`);
  }
}
