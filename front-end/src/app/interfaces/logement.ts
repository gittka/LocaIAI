import {TypeLogement} from "../models/typeLogement.enum";
import {User} from "./utilisateur";
import {Annonce} from "./annonce";

export interface Logement {
  id: number;
  adresse: string;
  ville: string;
  image: string;
  codePostal: string;
  typeLogement: TypeLogement;
  proprietaire: User;
  annonces: Annonce[];
}
