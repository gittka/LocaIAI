import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class AdminService {
  private urlServer = 'http://localhost:8080';

  constructor(private  httpClient: HttpClient) { }

  getClasses(): Observable<string[]> {
    return this.httpClient.get<string[]>(`${this.urlServer}/classes`);
  }

  generateData(className: string, rowCount: number): Observable<void> {
    return this.httpClient.get<void>(`${this.urlServer}/generate-data?className=${className}&rowCount=${rowCount}`, {});
  }
}
