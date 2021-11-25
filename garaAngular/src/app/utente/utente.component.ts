import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ActivatedRoute, Router } from '@angular/router';
import { garas } from '../model/gara-model';
import { GaraServiceService } from '../service/gara-service.service';
import { ParServiceService } from '../service/par-service.service';

@Component({
  selector: 'app-utente',
  templateUrl: './utente.component.html',
  styleUrls: ['./utente.component.css']
})
export class UtenteComponent implements OnInit {

 
  colonne: Array<String> | undefined;
  buttons : any;
  object : any;
  data : garas[] | undefined;
  emailUtente:any;
  sub: any;

  constructor(private garaService :GaraServiceService,private dialog: MatDialog,
    private partService : ParServiceService,
    private activatedroute:ActivatedRoute) { 
    
   
   }

  ngOnInit(): void {

    this.colonne = ["NOME","LUOGO","DATA"];

    this.buttons = [
      {
        title: "visibility",
        class: "search"
      },
      {
        title: "add_comment",
        class: "pencil"
      }
    ];
   
    this.getGara();

    this.sub=this.activatedroute.paramMap.subscribe(params => { 
      console.log(params);
       this.emailUtente = params.get('email');   
   });
  }

  public buttonFunction = (obj : any,title : any) => this.manageFunctions(obj,title);
   
  
  private getGara(){
    this.garaService.getListgara().subscribe((response) => {
      this.data = response;
    })
  }

  manageFunctions(gara: garas, title: string){
    switch (title) {
        case "visibility":
        this.openModal(gara);

        break;

        case "add_comment":
          this.prenotaGara(gara,title);
        break;
    }
  }



  openModal(richiesta: garas){

  }

  prenotaGara( gara: garas, title: string)
  {
    if(confirm("Sei sicuro di voler prenotare questa gara"))
    {
      let result = this.partService.prenotaGara(gara.id,this.emailUtente);

      result.subscribe((data)=> console.log(data));
    }

  }

}
