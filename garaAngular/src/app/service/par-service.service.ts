import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ParServiceService {

  apiAddress = /*window.location.origin*/ "http://localhost:8080" + "/part";

  constructor(private http: HttpClient) { }


  aggiungereStudenti(partecipante : any){ 

     return this.http.post<any>(this.apiAddress + '/add' ,partecipante,{responseType:'text' as 'json'});
  }
  
  prenotaGara(idGara : number, emailUtente :  string){ 

    return this.http.post<any>(this.apiAddress + '/prenota/' + idGara + "/" + emailUtente,{responseType:'text'});
 }
  
  
}
