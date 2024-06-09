import {TypeUtilisateur} from "../models/type.enum";

export interface User{
  id: number;
  nom: string  ;
  prenom: string  ;
  email: string ;
  motDePasse: string ;
  type: TypeUtilisateur ;
}
