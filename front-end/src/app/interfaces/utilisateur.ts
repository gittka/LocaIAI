import {Type} from "../models/type.enum";

export interface User{
  id: number|undefined;
  nom: string | undefined ;
  prenom: string | undefined ;
  email: string | undefined;
  motDePasse: string | undefined;
  type: Type ;
}
