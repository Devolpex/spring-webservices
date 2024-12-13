export interface Reservation {
  id: string;
  client: Client;
  chambre: Chambre;
  dateDebut: string;
  dateFin: string;
  preferences: string;
}

export interface Client {
  id: string;
  nom: string;
  prenom: string;
  email: string;
  telephone: string;
}

export interface Chambre {
  id: string;
  type: string;
  prix: number;
  disponible: boolean;
}
