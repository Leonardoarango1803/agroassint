import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
@Component({
  selector: 'app-ingreso-sistema',
  imports: [],
  templateUrl: './ingreso-sistema.component.html',
  standalone: true,
  styleUrl: './ingreso-sistema.component.css'
})
export class IngresoSistemaComponent {
  persona = {
    nombres: 'Juan Carlos',
    apellidos: 'Pérez Gómez',
    direccion: 'Av. Los Álamos 123, Lima',
    telefono: '987654321',
    zonaLaboral: 'Campo Nr° 3',
    supervisor: 'Ana Torres'
  };
}
