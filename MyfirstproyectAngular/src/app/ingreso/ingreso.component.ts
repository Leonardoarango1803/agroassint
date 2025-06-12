import { Component, OnInit } from '@angular/core';
import { gsap } from 'gsap';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-ingreso',
  imports: [FormsModule],
  templateUrl: './ingreso.component.html',
  standalone: true,
  styleUrl: './ingreso.component.css'
})
export class IngresoComponent implements OnInit {
  ngOnInit(): void {
    gsap.to(".cuadro-transparente", {
      duration: 1.5,
      opacity: 1,
      y: -20,
      ease: "power3.out",
      delay: 0.5
    });

    gsap.to(".bienvenido-trabajador", {
      duration: 1.8,
      opacity: 1,
      x: 20,
      ease: "power2.out"
    });
  }


  username = '';  // OK en Angular
  password = '';
  error = '';

  constructor(private authService: AuthService, private router: Router) {}

  login() {
    const datos = {
      usuario: this.username,
      contraseña: this.password
    };

    this.authService.login(datos).subscribe({
      next: (data) => {
        this.authService.guardarUsuarioEnSesion(data);
        this.router.navigate(['/sistema']).then(() => {
    window.location.reload();  // Refresca la página después de redirigir
  });
      },
      error: () => {
        this.error = 'Usuario o contraseña incorrectos';
        alert('Usuario o contraseña incorrectos');
      }
    });
  }
  contrasena(){
    alert('Contacta con Administracion en el area de Recursos Humanos');
  }
}