import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-ingreso-sistema',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './ingreso-sistema.component.html',
  styleUrl: './ingreso-sistema.component.css'
})
export class IngresoSistemaComponent {
  /*Simulados personales del back*/
  persona = {
    nombres: 'Juan Carlos',
    apellidos: 'Pérez Gómez',
    direccion: 'Av. Los Álamos 123, Lima',
    telefono: '987654321',
    zonaLaboral: 'Campo Nr° 3',
    supervisor: 'Ana Torres'
  };
/*simula datos del back*/
  historialAsistencia = [
    { fecha: '2025-05-14', entrada: '08:05', salida: '17:00', estado: 'Tardanza' },
    { fecha: '2025-05-13', entrada: '08:00', salida: '17:00', estado: 'Asistió' },
    { fecha: '2025-05-12', entrada: '08:00', salida: '17:00', estado: 'Asistió' },
    { fecha: '2025-05-11', entrada: '-', salida: '-', estado: 'Falta' },
    { fecha: '2025-05-10', entrada: '08:10', salida: '17:00', estado: 'Tardanza' },
  ];
  /*simula datos del extraido del back sobre el empleado*/
  horarioSemanal = [
    { dia: 'Lunes', entrada: '08:00', salida: '17:00', turno: 'Mañana' },
    { dia: 'Martes', entrada: '08:00', salida: '17:00', turno: 'Mañana' },
    { dia: 'Miércoles', entrada: '08:00', salida: '17:00', turno: 'Mañana' },
    { dia: 'Jueves', entrada: '08:00', salida: '17:00', turno: 'Mañana' },
    { dia: 'Viernes', entrada: '08:00', salida: '17:00', turno: 'Mañana' },
    { dia: 'Sábado', entrada: '09:00', salida: '13:00', turno: 'Medio día' },
    { dia: 'Domingo', entrada: '-', salida: '-', turno: 'Descanso' }
  ];
  seccionActiva = 'perfil';

  actualizarPerfil() {
    console.log('Datos actualizados:', this.persona);
    alert('Perfil actualizado exitosamente');
    localStorage.setItem('usuario', JSON.stringify(this.persona));
  }

  cambiarSeccion(seccion: string) {
    this.seccionActiva = seccion;
  }
}
