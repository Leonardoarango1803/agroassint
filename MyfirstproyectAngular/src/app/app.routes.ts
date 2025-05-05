import { NgModule } from '@angular/core';
import { Routes } from "@angular/router";
import { RegistrarseComponent } from "./registrarse/registrarse.component";
import { InicioComponent } from "./inicio/inicio.component";
import { IngresoSistemaComponent } from "./ingreso-sistema/ingreso-sistema.component";
import { PerfilComponent } from "./perfil/perfil.component";

export const routes: Routes = [
    {path:'', component:InicioComponent},
    {path:'inicio', component:InicioComponent},
    {path:'registro', component:RegistrarseComponent},
    {path: 'ingreso', component:IngresoSistemaComponent},
    {path: 'perfil', component:PerfilComponent},
]; 

