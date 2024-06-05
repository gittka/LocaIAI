import {Type} from "./type.enum";

export class Utilisateur{
  id: number|undefined;
  nom: string | undefined = "";
  prenom: string | undefined = "";
  email: string | undefined = "";
  motDePasse: string | undefined = "";
  token: string = "";
  type: Type = Type.GUEST;
}
