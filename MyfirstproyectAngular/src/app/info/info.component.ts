import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-info',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './info.component.html',
  styleUrl: './info.component.css'
})
export class InfoComponent {
  productos = [
    {
      id:1,
      nombre: 'Uva',
      nombreCientifico: 'Vitis vinifera',
      imagen: 'https://agraria.pe/imgs/a/lx/la-uva-una-apuesta-brillante-10430.jpg',
      imagenDetalle: 'https://agraria.pe/imgs/a/lx/la-uva-una-apuesta-brillante-10430.jpg',
      descripcion: `La compañía también ha ampliado sus sembríos de uva, incluyendo variedades como Ventura y Atlas, que son exportadas a Europa. Además, Agrokasa ha incorporado recientemente las variedades Sweet Celebration, Jack Salute y Sweet Favors, cultivadas con esmero en sus fundos de Ica. ...`,
      presentaciones: ['Sweet Globe', 'Red Globe', 'Candy Dreams']
    },
    {
      nombre: 'Espárrago',
      nombreCientifico: 'Asparagus officinalis',
      imagen: 'https://agrawdata.com/wp-content/uploads/2024/03/esparragos-siendo-cosechados.webp',
      imagenDetalle: 'https://agrawdata.com/wp-content/uploads/2024/03/esparragos-siendo-cosechados.webp',
      descripcion: 'La cúrcuma es conocida por sus propiedades antioxidantes y antiinflamatorias...',
      presentaciones: ['Cúrcuma fresca', 'Cúrcuma molida']
    },
    {
      nombre: 'Palta',
      nombreCientifico: 'Persea americana',
      imagen: 'https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcQYj9I8VLqH5PQB4Cr-OhP5Fn_2vC8-0FfZVKSLYbf3VtRjYpCijYl989WDj3ZxX5HajwEJzXwZ0jQS6sh_xnu_Hg',
      imagenDetalle: 'https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcQYj9I8VLqH5PQB4Cr-OhP5Fn_2vC8-0FfZVKSLYbf3VtRjYpCijYl989WDj3ZxX5HajwEJzXwZ0jQS6sh_xnu_Hg',
      descripcion: 'El achiote se utiliza como colorante y condimento en diversas cocinas...',
      presentaciones: ['Achiote entero', 'Achiote molido']
    },
    {
      nombre: 'Arándano azul',
      nombreCientifico: 'Vaccinium corymbosum',
      imagen: 'https://www.webconsultas.com/sites/default/files/styles/wch_image_schema/public/media/0d/temas/arandanos.jpg',
      imagenDetalle: 'https://www.webconsultas.com/sites/default/files/styles/wch_image_schema/public/media/0d/temas/arandanos.jpg',
      descripcion: 'El cacao es el fruto del árbol Theobroma cacao, utilizado para hacer chocolate...',
      presentaciones: ['Cacao en grano', 'Cacao en polvo']
    }

  ];

  productoSeleccionado: any;

  mostrarDescripcion(producto: any) {
    this.productoSeleccionado = producto;
    const modal = new (window as any).bootstrap.Modal(
      document.getElementById('productoModal')
    );
    modal.show();
  }
}
