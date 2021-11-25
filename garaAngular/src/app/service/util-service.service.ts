import { HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { garas } from '../model/gara-model';
import { GaraServiceService } from './gara-service.service';

@Injectable({
  providedIn: 'root'
})
export class UtilServiceService {

  sub : any;
  public gara: garas[] | undefined;

  constructor(private garaService :GaraServiceService) { }



  getListGara() : any
  {

    this.garaService.getListgara().subscribe((response) => {
        this.gara = response;
      },
      (error: HttpErrorResponse) => {
        return;
      }
    );

     return this.gara;
  }

}




