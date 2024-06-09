import {User} from "./utilisateur";
import {Annonce} from "./annonce";

export interface Evaluation {
  id: number;
  note: number;
  description: string;
  date: Date;
  hote: User;
  annonce: Annonce;
}
