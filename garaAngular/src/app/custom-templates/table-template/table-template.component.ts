import { Component, Input, OnInit } from '@angular/core';
import { UtilServiceService } from 'src/app/service/util-service.service';

@Component({
  selector: 'app-table-template',
  templateUrl: './table-template.component.html',
  styleUrls: ['./table-template.component.css']
})
export class TableTemplateComponent implements OnInit {


  
  @Input()
  objects: any;

  @Input()
  buttons: any;

  @Input()
  buttonFunctions: any;

  @Input()
  columns: any;

  @Input()
  emptyMessage: string | undefined;

  items: any;

  
  constructor(private utilService : UtilServiceService) { }

  ngOnInit(): void {
    
    this.items = [];
    this.items = this.columns.map((c: any) => this.toCamelCase(c));
    
  }

  toCamelCase(c :any){
    const tokens = c.split(" ");
    if (tokens.length == 1){
      return c.toLowerCase();
    }  else {
      return tokens[0].toLowerCase()+tokens[1][0]+tokens[1].substring(1).toLowerCase();
    } 
  }

   
  buttonFunction(obj : any, title : any) {
    
    this.buttonFunctions(obj,title); 
 
  }



}
