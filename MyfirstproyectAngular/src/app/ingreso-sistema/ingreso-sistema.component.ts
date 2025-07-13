import { Component, OnInit } from '@angular/core';
import { FormsModule, ReactiveFormsModule, FormBuilder, FormGroup } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { jsPDF } from 'jspdf';
import autoTable from 'jspdf-autotable';

@Component({
  selector: 'app-ingreso-sistema',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  templateUrl: './ingreso-sistema.component.html',
  styleUrl: './ingreso-sistema.component.css'
})
export class IngresoSistemaComponent implements OnInit {
  seccionActiva: string = 'perfil';
  doc: jsPDF | null = null;
  mostrarVistaPrevia: boolean = false;
  formulario: FormGroup;
  solicitudes: any[] = [];

  tiposDocumento = [
    'Reporte de asistencia',
    'Reporte de faltas',
    'Permiso por faltas',
    'Constancia de pago'
  ];

  persona: any = {
    nombres: '',
    apellidos: '',
    direccion: '',
    telefono: '',
    zonaLaboral: '',
    supervisor: '',
    sueldo: '',
    fechaingreso: '',
  };

  historialAsistencia = [
    { fecha: '2025-05-14', entrada: '08:05', salida: '17:00', estado: 'Tardanza' },
    { fecha: '2025-05-13', entrada: '08:00', salida: '17:00', estado: 'Asistió' },
    { fecha: '2025-05-12', entrada: '08:00', salida: '17:00', estado: 'Asistió' },
    { fecha: '2025-05-11', entrada: '-', salida: '-', estado: 'Falta' },
    { fecha: '2025-05-10', entrada: '08:10', salida: '17:00', estado: 'Tardanza' },
  ];

  horarioSemanal = [
    { dia: 'Lunes', entrada: '08:00', salida: '17:00', turno: 'Mañana' },
    { dia: 'Martes', entrada: '08:00', salida: '17:00', turno: 'Mañana' },
    { dia: 'Miércoles', entrada: '08:00', salida: '17:00', turno: 'Mañana' },
    { dia: 'Jueves', entrada: '08:00', salida: '17:00', turno: 'Mañana' },
    { dia: 'Viernes', entrada: '08:00', salida: '17:00', turno: 'Mañana' },
    { dia: 'Sábado', entrada: '09:00', salida: '13:00', turno: 'Medio día' },
    { dia: 'Domingo', entrada: '-', salida: '-', turno: 'Descanso' }
  ];

  constructor(
    private router: Router,
    private fb: FormBuilder,
    private http: HttpClient
    
  ) {
    this.formulario = this.fb.group({
      tipoDocumento: [''],
      descripcion: ['']
    });
  }

  ngOnInit(): void {
  const usuarioString = localStorage.getItem("usuario");
  this.cargarSolicitudes();
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
      supervisor: 'Administracion'
    };
  }
}


  actualizarPerfil() {
    console.log('Datos actualizados:', this.persona);
    alert('Perfil actualizado exitosamente');
  }

  cambiarSeccion(seccion: string) {
    this.seccionActiva = seccion;
  }

  cerrarSesion() {
    localStorage.clear();
    sessionStorage.clear();
    this.router.navigate(['/ingreso']);
  }

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

Constancia generada por Agroassint Web
    `;

    this.doc.setFontSize(12);
    this.doc.text(texto, 20, 30, { maxWidth: 170 });

    const img = new Image();
    img.src = 'https://upload.wikimedia.org/wikipedia/commons/thumb/7/7f/Firma_Christian_Vittori.svg/3280px-Firma_Christian_Vittori.svg.png';

    img.onload = () => {
      this.doc!.addImage(img, 'PNG', 20, 156, 40, 20);

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

  enviarSolicitud(): void {
  const usuarioString = localStorage.getItem("usuario");

  if (!usuarioString) {
    alert('No hay usuario autenticado');
    return;
  }

  const usuario = JSON.parse(usuarioString);

  // Validar si existe el ID del empleado
  if (!usuario.empleado || !usuario.empleado.id) {
    alert('No se encontró el ID del empleado');
    return;
  }

  const solicitud = {
  tipo: this.formulario.value.tipoDocumento,
  descripcion: this.formulario.value.descripcion || '',
  fecha_solicitud: new Date().toISOString().split('T')[0],
  estado: 'pendiente',
  empleado: {
    id: usuario.empleado.id
  }
};

  console.log('Solicitud enviada:', solicitud); // <-- para verificar en consola

  this.http.post('https://agroassint.onrender.com/api/solicitudes', solicitud)
  .subscribe({
    next: () => {
      alert('Solicitud enviada correctamente');
      this.formulario.reset(); // 🔁 Limpiar el formulario
      this.cargarSolicitudes(); // actualiza tabla
    },
    error: () => alert('Error al enviar la solicitud')
  });
}

cargarSolicitudes() {
  const usuarioString = localStorage.getItem("usuario");
  if (!usuarioString) return;

  const usuario = JSON.parse(usuarioString);
  const empleadoId = usuario.empleado.id;

  this.http.get<any[]>(`https://agroassint.onrender.com/api/solicitudes/empleado/${empleadoId}`)
    .subscribe({
      next: data => this.solicitudes = data,
      error: err => console.error('Error cargando solicitudes', err)
    });
}

}
