import { Component } from '@angular/core';

@Component({
  selector: 'app-header',
  imports: [],
  standalone: true,
  templateUrl: './header.component.html',
  styleUrl: './header.component.css'
})
export class HeaderComponent {
  logout() {
    // Aquí puedes limpiar el localStorage o token
    localStorage.clear();
    
  }
}
