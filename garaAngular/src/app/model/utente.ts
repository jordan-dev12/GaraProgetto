export class Utente {

    id: number;
    nome: string;
    cognome: string;
    email:string;


    constructor(jsonDipendente: any){
        this.id = jsonDipendente.id;
        this.nome = jsonDipendente.nome;
        this.cognome = jsonDipendente.cognome;
        this.email = jsonDipendente.mail;
    }
    
     
}
