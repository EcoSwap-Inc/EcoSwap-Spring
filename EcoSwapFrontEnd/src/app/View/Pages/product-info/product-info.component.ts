import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-product-info',
  templateUrl: './product-info.component.html',
  styleUrls: ['./product-info.component.css']
})
export class ProductInfoComponent {
  user_id!: number; 
  troca: any = {produto: {nome: "", descricao: "", usuario: {nome: "", cidade: "", uf: ""}, categoria: {nome: ""}}, usuario: {nome: "", cidade:"", uf:""}};
  rating: any = 0;

  constructor(private route: ActivatedRoute) {
    route.params.subscribe(() => {
      this.user_id = parseInt(localStorage.getItem('user_id') ?? '1');
      let id = this.route.snapshot.paramMap.get('id');
      let token = localStorage.getItem('token');

      fetch('http://localhost:8080/api/troca/' + id, {
        method: 'GET',
        headers: { 
          'Accept': 'application/json', 
          'Content-Type': 'application/json', 
          'Authorization': `${token}` 
        },
      })
      .then(response => response.json())
      .then((data) => {
        this.troca = data;
        
        fetch("http://localhost:8080/api/avaliacao/mediaTrocas/" + this.troca.usuario.id_usuario, {
          method: 'GET',
          headers: { 
            'Accept': 'application/json', 
            'Content-Type': 'application/json',
            'Authorization': `${token}` 
          },
        })
        .then(response => response.json())
        .then((data) => {
          this.rating = data.resultado;
        })
      })
    });
  }

}
