import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private apiUrl = 'https://agroassint.onrender.com/api/auth/login';

  constructor(private http: HttpClient) {}


  login(datos: { usuario: string; contraseña: string }) {
  return this.http.post<any>(this.apiUrl, datos);
}

  guardarUsuarioEnSesion(usuario: any) {
  localStorage.setItem('usuario', JSON.stringify(usuario));
  localStorage.setItem('userLogged', 'true'); 
}

  obtenerUsuarioSesion() {
    const data = sessionStorage.getItem('usuario');
    return data ? JSON.parse(data) : null;
  }

  cerrarSesion() {
    sessionStorage.clear();
  }
}