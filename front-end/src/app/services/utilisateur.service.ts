import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable, subscribeOn} from "rxjs";
import {User} from "../interfaces/utilisateur";

@Injectable({
  providedIn: 'root'
})
export class UtilisateurService {
  private serverUrl: string = 'http://localhost:8080';

  constructor(private httpClient: HttpClient) {
  }

  saveUtilisateur(utilisateur: User): Observable<User> {
    return this.httpClient.post<User>(`${this.serverUrl}/utilisateur`, utilisateur);
  }

  updateUtilisateur(utilisateur: User): Observable<User> {
    return this.httpClient.put<User>(`${this.serverUrl}/updateUtilisateur`, utilisateur,{headers:{
      'Content-Type':'application/json'
      }});
  }

  deleteUtilisateur(id: number): Observable<User> {
    return this.httpClient.delete<User>(`${this.serverUrl}/delete/${id}`);
  }

  getAllUtilisateur(): Observable<User[]> {
    return this.httpClient.get<User[]>(`${this.serverUrl}/utilisateurs`);
  }
}
