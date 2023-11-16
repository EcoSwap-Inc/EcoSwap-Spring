import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-product-info',
  templateUrl: './product-info.component.html',
  styleUrls: ['./product-info.component.css']
})
export class ProductInfoComponent {
  produto: any = {nome: "", descricao: "", usuario: {nome: "", cidade: "", uf: ""}, categoria: {nome: ""}};
  rating: any = 0;

  constructor(private route: ActivatedRoute) {
    route.params.subscribe(() => {
      let id = this.route.snapshot.paramMap.get('id');
      let token = localStorage.getItem('token')

      fetch('http://localhost:8080/api/produto/' + id, {
        method: 'GET',
        headers: { 
          'Accept': 'application/json', 
          'Content-Type': 'application/json', 
          'Authorization': `${token}` 
        },
      })
      .then(response => response.json())
      .then((data) => {
        this.produto = data;
        
        fetch("http://localhost:8080/api/avaliacao/mediaTrocas/" + this.produto.usuario.id_usuario, {
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
