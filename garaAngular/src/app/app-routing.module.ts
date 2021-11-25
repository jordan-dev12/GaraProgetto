import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RegistrazioneComponent } from './registrazione/registrazione.component';
import { UtenteComponent } from './utente/utente.component';

const routes: Routes = [
  {path : "login" , component : LoginComponent},
  {path : "registrazione" , component : RegistrazioneComponent} ,
  {path : "" , component : HomeComponent} ,
  {path: "utente/:email" ,component : UtenteComponent  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
