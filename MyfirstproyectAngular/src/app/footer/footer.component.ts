import { Component } from '@angular/core';
import {Router, RouterModule} from '@angular/router';
import {CommonModule} from '@angular/common';

// @ts-ignore
@Component({
  selector: 'app-footer',
  imports: [CommonModule, RouterModule],
  standalone: true,
  templateUrl: './footer.component.html',
  styleUrl: './footer.component.css',
  preserveWhitespaces: true
})
export class FooterComponent {
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
}
