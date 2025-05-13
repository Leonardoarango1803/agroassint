import { Component } from '@angular/core';
import {FormsModule} from '@angular/forms';
import {CommonModule} from '@angular/common';

@Component({
  selector: 'app-postular',
  imports: [
    FormsModule,CommonModule,
  ],
  templateUrl: './postular.component.html',
  standalone: true,
  styleUrl: './postular.component.css'
})
export class PostularComponent {
  form = {
    nombre: '',
    celular: '',
    email: '',
    mensaje: ''
  };

  postulaciones: any[] = [];


  enviarFormulario() {
    if (this.form.nombre && this.form.email && this.form.mensaje) {
      this.postulaciones.push({ ...this.form });
      window.alert('Formulario enviado con éxito');
      console.log("Formulario enviado con éxito");
      this.form = { nombre: '', celular: '', email: '', mensaje: '' };
    } else {
      window.alert('Por favor completa todos los campos');
    }
  }

  mostrarLista = false;

  mostrarPostulaciones() {
    this.mostrarLista = !this.mostrarLista;
  }
}
