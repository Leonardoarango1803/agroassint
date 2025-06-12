import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router'; // 
declare var bootstrap: any;
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

irAPortalEmpleado() {
  const isLogged = localStorage.getItem('userLogged') === 'true';
  if (isLogged) {
    this.router.navigate(['/sistema']);
  } else {
    this.router.navigate(['/ingreso']);
  }
}
ngAfterViewInit(): void {
    const navLinks = document.querySelectorAll('.navbar-nav .nav-link');
    const navCollapse = document.getElementById('navbarNav');
    const menuToggleButton = document.getElementById('menuToggleButton');

    // Cierra el menú al hacer clic en cualquier enlace
    navLinks.forEach(link => {
      link.addEventListener('click', () => {
        if (navCollapse?.classList.contains('show')) {
          new bootstrap.Collapse(navCollapse).hide();
        }
      });
    });
   
    // Alterna el menú al hacer clic en el botón hamburguesa
    menuToggleButton?.addEventListener('click', () => {
      if (navCollapse?.classList.contains('show')) {
        new bootstrap.Collapse(navCollapse).hide();
      } else {
        new bootstrap.Collapse(navCollapse).show();
      }
    });
  }
 
  navbarOpen = false;

toggleNavbar() {
  this.navbarOpen = !this.navbarOpen;
}
cerrarSesion() {
  localStorage.clear();        // Borra todo el localStorage
  sessionStorage.clear();      // Borra todo el sessionStorage
  this.router.navigate(['/ingreso']).then(() => {
    window.location.reload();  // Refresca la página después de redirigir
  });
}
}
