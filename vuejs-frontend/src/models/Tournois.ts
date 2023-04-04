export interface Tournoi {
    id : number;
    name : string;
    description : string;
    state : string; //EN COURS ...
    mode : string; //POULE / ARBRE
    adminId : number;
    moderatorsId : number[];
    participants : string[];
    matchs : Match[];


}

export interface Match {
    id: number;
    nextMatch : number; //id du match d'apres
    round : number;
    participant1 : string;
    participant2: string;
    state : string; //EN COURS, A VENIR, TERMINE ...
    score1: number; //score du participant1
    score2: number; //score du participant2
    date : Date;
}