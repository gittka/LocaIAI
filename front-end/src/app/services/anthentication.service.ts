import {Injectable} from '@angular/core';
import {BehaviorSubject, map, Observable} from "rxjs";
import {Utilisateur} from "../models/utilisateur.model";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class AnthenticationService {
  public currentUtilisateur: Observable<Utilisateur>;
  private currnetUserSubject: BehaviorSubject<Utilisateur>;

  constructor(private http: HttpClient) {
    let storage;
    const storageUtilisateurAsStr = localStorage.getItem('currentUtilisateur');
    if (storageUtilisateurAsStr) {
      storage = JSON.parse(storageUtilisateurAsStr);
    }
    this.currnetUserSubject = new BehaviorSubject<Utilisateur>(storage);
    this.currentUtilisateur = this.currnetUserSubject.asObservable();
  }

  public get currentUserValue(): Utilisateur {
    return this.currnetUserSubject.value;
  }

  login(user: Utilisateur): Observable<Utilisateur> {
    return this.http.post<any>("http://localhost:8080/sign-in", user).pipe(
      map(response => {
        if (response) {
          localStorage.setItem("currentUtilisateur", JSON.stringify(response));
          this.currnetUserSubject.next(response);
        }
        return response;
      })
    );
  }

  register(user: Utilisateur):Observable<any>{
    return this.http.post("http://localhost:8080/sign-up", user);
  }

  logout(){
    localStorage.removeItem('currentUtilisateur');
    this.currnetUserSubject.next(new Utilisateur);
  }

}
