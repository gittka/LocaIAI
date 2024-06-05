import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable, subscribeOn} from "rxjs";
import {Utilisateur} from "../models/utilisateur.model";
import {User} from "../interfaces/utilisateur";

@Injectable({
  providedIn: 'root'
})
export class UtilisateurService {
  private serverUrl:string ='http://localhost:8080';

  constructor(private httpClient : HttpClient) {
  }
  saveUtilisateur(utilisateur: Utilisateur): Observable<User>{
    return this.httpClient.post<User>(`${this.serverUrl}/utilisateur`, utilisateur);
  }
  updateUtilisateur(utilisateur: Utilisateur): Observable<User>{
    return this.httpClient.put<User>(`${this.serverUrl}/updateUtilisateur`, utilisateur);
  }
  deleteUtilisateur(id: number): Observable<void>{
    return this.httpClient.delete<void>(`${this.serverUrl}/delete/${id}`);
  }

  getAllUtilisateur():Observable<User[]>{
    return this.httpClient.get<User[]>(`${this.serverUrl}/utilisateurs`);
  }
}
