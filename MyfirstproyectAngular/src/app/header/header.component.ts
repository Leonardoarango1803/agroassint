import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router'; // 

@Component({
  selector: 'app-header',
  imports: [CommonModule,
  ],
  standalone: true,
  templateUrl: './header.component.html',
  styleUrl: './header.component.css'
})
export class HeaderComponent implements OnInit{
  constructor(private router: Router) {}
  
  isLoggedIn = false;

ngOnInit(): void {
  this.isLoggedIn = localStorage.getItem('userLogged') === 'true';
}
cerrarSesion() {
  localStorage.clear();        // Borra todo el localStorage
  sessionStorage.clear();      // Borra todo el sessionStorage
  this.router.navigate(['/ingreso']).then(() => {
    window.location.reload();  // Refresca la página después de redirigir
  });
}
}
