import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router'; // 
import { BrowserModule } from '@angular/platform-browser';

@Component({
  selector: 'app-ingreso-sistema',
  standalone: true,
  imports: [FormsModule, CommonModule,],
  templateUrl: './ingreso-sistema.component.html',
  styleUrl: './ingreso-sistema.component.css'
})
export class IngresoSistemaComponent implements OnInit{

  constructor(private router: Router) {}
  /*Simulados personales del back*/
  seccionActiva: string = 'perfil';

  persona: any = {
    nombres: '',
    apellidos: '',
    direccion: '',
    telefono: '',
    zonaLaboral: '',
    supervisor: ''
  };

  ngOnInit(): void {
  const usuarioString = localStorage.getItem("usuario");

  if (usuarioString) {
    const usuario = JSON.parse(usuarioString);
    this.persona = {
      nombres: usuario.empleado.nombres,
      apellidos: usuario.empleado.apellidos,
      direccion: usuario.empleado.direccion,
      telefono: usuario.empleado.telefono,
      zonaLaboral: usuario.empleado.area.nombre,
      supervisor: '' // Asigna según tu lógica
    };
  }
}
/*simula datos del back asistencia*/
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

  actualizarPerfil() {
    console.log('Datos actualizados:', this.persona);
    alert('Perfil actualizado exitosamente');
    //localStorage.setItem('usuario', JSON.stringify(this.persona));//
  }

  cambiarSeccion(seccion: string) {
    this.seccionActiva = seccion;
  }

  cerrarSesion() {
  localStorage.clear();        // Borra todo el localStorage
  sessionStorage.clear();      // Borra todo el sessionStorage
  this.router.navigate(['/ingreso']); // Redirige al login o donde quieras
}
}
