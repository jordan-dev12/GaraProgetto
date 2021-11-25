import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class GaraServiceService {

  apiAddress = /*window.location.origin*/ "http://localhost:8080" + "/gara";
  jsonRichieste = [];

  constructor(private http: HttpClient) { }

  
  getListgara() 
  {
    return this.http.get<any>(this.apiAddress + '/list');
  }

  

}
