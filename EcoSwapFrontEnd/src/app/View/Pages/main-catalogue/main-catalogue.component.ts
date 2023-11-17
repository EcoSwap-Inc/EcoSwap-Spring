import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-main-catalogue',
  templateUrl: './main-catalogue.component.html',
  styleUrls: ['./main-catalogue.component.css']
})
export class MainCatalogueComponent {
  produtosNovos!: any[];
  produtosPopulares!: any[];

  constructor(private route: ActivatedRoute) {
    let token = localStorage.getItem('token')
    route.params.subscribe(() => {
      fetch('http://localhost:8080/api/produto/novos', {
        method: 'GET',
        headers: { 
          'Accept': 'application/json', 
          'Content-Type': 'application/json', 
          'Authorization': `${token}` 
        },
      })
      .then(response => response.json())
      .then((data) => {
        this.produtosNovos = data;
      })

      fetch('http://localhost:8080/api/produto/populares', {
        method: 'GET',
        headers: { 
          'Accept': 'application/json', 
          'Content-Type': 'application/json', 
          'Authorization': `${token}` 
        },
      })
      .then(response => response.json())
      .then((data) => {
        this.produtosPopulares = data;
      })
    })
  }

}
