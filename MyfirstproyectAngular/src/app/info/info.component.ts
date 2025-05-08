import { Component } from '@angular/core';
import {CommonModule} from '@angular/common';

@Component({
  selector: 'app-info',
  imports: [CommonModule],
  templateUrl: './info.component.html',
  standalone: true,
  styleUrl: './info.component.css'
})
export class InfoComponent {
  productos = [
    {
      nombre: 'Uva',
      nombreCientifico: 'Vitis vinifera',
      imagen: 'https://agraria.pe/imgs/a/lx/la-uva-una-apuesta-brillante-10430.jpg',
      imagenDetalle: 'assets/img/jengibre_detalle.jpg',
      descripcion: `El jengibre es una especie obtenida de la planta Zingiber officinale, planta herbácea perenne de la familia Zingiberaceae...`,
      presentaciones: ['Jengibre fresco', 'Jengibre deshidratado', 'Jengibre molido']
    },
    {
      nombre: 'Espárrago',
      nombreCientifico: 'Asparagus officinalis',
      imagen: 'https://agrawdata.com/wp-content/uploads/2024/03/esparragos-siendo-cosechados.webp',
      imagenDetalle: 'assets/img/curcuma_detalle.jpg',
      descripcion: 'La cúrcuma es conocida por sus propiedades antioxidantes y antiinflamatorias...',
      presentaciones: ['Cúrcuma fresca', 'Cúrcuma molida']
    },
    {
      nombre: 'Palta',
      nombreCientifico: 'Persea americana',
      imagen: 'https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcQYj9I8VLqH5PQB4Cr-OhP5Fn_2vC8-0FfZVKSLYbf3VtRjYpCijYl989WDj3ZxX5HajwEJzXwZ0jQS6sh_xnu_Hg',
      imagenDetalle: 'assets/img/achiote_detalle.jpg',
      descripcion: 'El achiote se utiliza como colorante y condimento en diversas cocinas...',
      presentaciones: ['Achiote entero', 'Achiote molido']
    },
    {
      nombre: 'Arándano azul',
      nombreCientifico: 'Vaccinium corymbosum',
      imagen: 'https://campograndeperu.com/wp-content/uploads/2024/03/arandanos-1.jpg',
      imagenDetalle: 'assets/img/cacao_detalle.jpg',
      descripcion: 'El cacao es el fruto del árbol Theobroma cacao, utilizado para hacer chocolate...',
      presentaciones: ['Cacao en grano', 'Cacao en polvo']
    }
  ];

  productoSeleccionado: any;

}
