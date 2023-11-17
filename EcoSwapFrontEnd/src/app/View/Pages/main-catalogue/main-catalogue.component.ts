import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-main-catalogue',
  templateUrl: './main-catalogue.component.html',
  styleUrls: ['./main-catalogue.component.css']
})
export class MainCatalogueComponent {
  trocasNovas!: any[];
  trocasPopulares!: any[];

  constructor(private route: ActivatedRoute) {
    let token = localStorage.getItem('token')
    route.params.subscribe(() => {
      fetch('http://localhost:8080/api/troca/novos', {
        method: 'GET',
        headers: { 
          'Accept': 'application/json', 
          'Content-Type': 'application/json', 
          'Authorization': `${token}` 
        },
      })
      .then(response => response.json())
      .then((data) => {
        this.trocasNovas = data;
      })

      fetch('http://localhost:8080/api/troca/populares', {
        method: 'GET',
        headers: { 
          'Accept': 'application/json', 
          'Content-Type': 'application/json', 
          'Authorization': `${token}` 
        },
      })
      .then(response => response.json())
      .then((data) => {
        this.trocasPopulares = data;
      })
    })
  }

}
