export interface Tournament {
    id : number;
    admin: string;
    name : string;
    description : string;
    state : string; 
    participants : string[];
    matchs : Match[];
}

export interface Match {
    id: number;
    idtournoi: number;
    state: string;
    participant1 : string;
    result1 : number;
    participant2: string;
    result2 : number;
    level : number;
    nextMatch : number; //id du match d'apres
}