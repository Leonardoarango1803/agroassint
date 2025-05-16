import { Component } from '@angular/core';
import { gsap} from 'gsap';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
@Component({
  selector: 'app-ingreso',
  imports: [FormsModule],
  templateUrl: './ingreso.component.html',
  standalone: true,
  styleUrl: './ingreso.component.css'
})
export class IngresoComponent {
  ngOnInit(): void {
    // Animación del cuadro transparente
    gsap.to(".cuadro-transparente", {
      duration: 1.5,
      opacity: 1,
      y: -20,
      ease: "power3.out",
      delay: 0.5
    });

    // Animación de bienvenida
    gsap.to(".bienvenido-trabajador", {
      duration: 1.8,
      opacity: 1,
      x: 20,
      ease: "power2.out"
    });
  }

  username = '';
  password = '';

  constructor(private router: Router) {}

  login() {
    if (this.username === 'admin' && this.password === '1234') {
      localStorage.setItem('userLogged', 'true');
      this.router.navigate(['/sistema']);
    } else {
      alert('Usuario o contraseña incorrectos');
    }
  }
}
