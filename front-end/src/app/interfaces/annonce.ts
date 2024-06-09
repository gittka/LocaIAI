import {Disponibilite} from "../models/disponibilite.enum";
import {User} from "./utilisateur";
import {Logement} from "./logement";

export interface Annonce {
  id: number;
  titre: string;
  description: string;
  prix: number;
  note: number;
  type: string;
  promotion: number;
  disponibilite: Disponibilite;
  debutAnnonce: Date;
  finAnnonce: Date;
  hote: User;
  logement: Logement;
  evaluations: any[];
}
