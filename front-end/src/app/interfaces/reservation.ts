import {Annonce} from "./annonce";
import {StatutReservation} from "../models/statut.enum";
import {User} from "./utilisateur";

export interface Reservation {
  id: number;
  dateReservation: Date;
  prixTotal: number;
  statut: StatutReservation;
  nombrePersonnes: number;
  finReservation: Date;
  annonce: Annonce;
  client: User;
}
