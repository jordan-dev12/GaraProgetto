import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ParServiceService } from 'src/app/service/par-service.service';


@Component({
  selector: 'app-form-template',
  templateUrl: './form-template.component.html',
  styleUrls: ['./form-template.component.css']
})
export class FormTemplateComponent implements OnInit {

  
  @Input() submitFunction: any;
  @Input() login : boolean | undefined;
  @Input() registrazione : any;
  
 
  constructor(private partService : ParServiceService,
              private router: Router) { }

  ngOnInit(): void {
  }
  
  onSubmit(templateForm : any) : any
  {

    this.submitFunction(templateForm);
        
  }

  annullare(templateForm : any)
  {
    templateForm.form.reset();

  }
}
