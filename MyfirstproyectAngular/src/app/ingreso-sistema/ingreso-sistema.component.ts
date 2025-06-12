import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router'; // 
import { BrowserModule } from '@angular/platform-browser';
import { jsPDF } from 'jspdf';
import autoTable from 'jspdf-autotable';
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
  doc: jsPDF | null = null;

  persona: any = {
    nombres: '',
    apellidos: '',
    direccion: '',
    telefono: '',
    zonaLaboral: '',
    supervisor: '',
    sueldo:'',
    fechaingreso:'',
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
      sueldo: usuario.empleado.salarioBase,
      fechaingreso: usuario.empleado.fechaIngreso,
      supervisor: 'Administracion' // Asigna según tu lógica
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

  generatePDF() {
    const doc = new jsPDF();
    doc.setFontSize(16);
    doc.text('Horario Semanal', 70, 10);

    autoTable(doc, {
      startY: 20,
      head: [['Día', 'Entrada', 'Salida', 'Turno']],
      body: this.horarioSemanal.map(item => [
        item.dia, item.entrada, item.salida, item.turno
      ])
    });

    doc.save('HorarioSemanal.pdf');
  }

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




mostrarVistaPrevia: boolean = false;

generarConstancia(): void {
  this.doc = new jsPDF();

  const texto = `
                                          CONSTANCIA DE TRABAJO

Se deja constancia que el(la) Sr(a). ${this.persona.nombres} ${this.persona.apellidos},
con dirección en ${this.persona.direccion} y número telefónico ${this.persona.telefono},
labora en nuestra empresa en el área de ${this.persona.zonaLaboral},
con fecha de ingreso desde ${this.persona.fechaingreso},
hasta la fecha.


Durante este tiempo, ha cumplido con responsabilidad y eficiencia las funciones asignadas, mostrando
una conducta intachable y compromiso con sus labores.




La presente se expide a solicitud del interesado para los fines que estime convenientes.






Atentamente,
Empresa Agroka




____________________
Miguel Araujo Granda
GERENTE RECURSOS HUMANOS










Constacia generada por Agroassint Web
  `;

  this.doc.setFontSize(12);
  this.doc.text(texto, 20, 30, { maxWidth: 170 });

  // Cargar imagen de firma
  const img = new Image();
  img.src = 'https://upload.wikimedia.org/wikipedia/commons/thumb/7/7f/Firma_Christian_Vittori.svg/3280px-Firma_Christian_Vittori.svg.png';

  img.onload = () => {
    // Agrega imagen de firma al PDF
    this.doc!.addImage(img, 'PNG', 20, 156, 40, 20); // posición x, y, ancho, alto

    const blob = this.doc!.output('blob');
    const url = URL.createObjectURL(blob);

    this.mostrarVistaPrevia = true;

    setTimeout(() => {
      const visor: any = document.getElementById('visorPDF');
      if (visor) {
        visor.src = url;
      }
    }, 100);
  };
}

cerrarVistaPrevia(): void {
  this.mostrarVistaPrevia = false;
}

  descargarPDF(): void {
    if (this.doc) {
      this.doc.save('constancia-trabajo.pdf');
    }
  }
}


