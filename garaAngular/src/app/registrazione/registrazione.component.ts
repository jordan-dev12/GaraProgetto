import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ParServiceService } from '../service/par-service.service';

@Component({
  selector: 'app-registrazione',
  templateUrl: './registrazione.component.html',
  styleUrls: ['./registrazione.component.css']
})
export class RegistrazioneComponent implements OnInit {


  public submitFunction = (form : any)  => this.inserisciRichiesta(form);

  constructor(private partService : ParServiceService,
              private router: Router ) { }


  ngOnInit(): void {
  }
  
  inserisciRichiesta(form: any): void{
     
     console.log(form);
     let resp =  this.partService.aggiungereStudenti(form);
      
      resp.subscribe(data => {
        if(data == "OK") 
        { 
          console.log(form.email);
          this.router.navigate(['utente', form.email]);
      
        }
      });
      
        
  }

  
}
