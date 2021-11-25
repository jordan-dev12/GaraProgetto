import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-nav-template',
  templateUrl: './nav-template.component.html',
  styleUrls: ['./nav-template.component.css']
})
export class NavTemplateComponent implements OnInit {


  @Input() login: any;
  @Input() home: any;
  @Input() registrazione: any;
  @Input() utente : any;
  
  isCollapsed = true;
  constructor() { }

  ngOnInit(): void {
  }

  toggleCollapsed(): void {
    this.isCollapsed = !this.isCollapsed;
  }


}
