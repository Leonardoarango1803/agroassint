import { NgModule } from '@angular/core';
import { Routes } from "@angular/router";
import { InicioComponent } from "./inicio/inicio.component";
import { IngresoSistemaComponent } from "./ingreso-sistema/ingreso-sistema.component";
import { PerfilComponent } from "./perfil/perfil.component";
import {NosotrosComponent} from './nosotros/nosotros.component';
import {PostularComponent} from './postular/postular.component';
import {IngresoComponent} from './ingreso/ingreso.component';
import {InfoComponent} from './info/info.component';

export const routes: Routes = [
    {path:'', component:InicioComponent},
    {path:'inicio', component:InicioComponent},
    {path: 'sistema', component:IngresoSistemaComponent},
    {path: 'perfil', component:PerfilComponent},
  {path: 'nosotros',component:NosotrosComponent},
  {path: 'postular',component:PostularComponent},
  {path:"ingreso",component:IngresoComponent},
  {path:'info',component:InfoComponent},
];

