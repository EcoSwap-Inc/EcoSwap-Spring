import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-category-catalogue',
  templateUrl: './category-catalogue.component.html',
  styleUrls: ['./category-catalogue.component.css']
})
export class CategoryCatalogueComponent {
  trocas!: any[];
  id!: string | null;
  categoria!: string;

  constructor(private route: ActivatedRoute) {
    route.params.subscribe(() => {
      this.id = this.route.snapshot.paramMap.get('id');

      let categorias_id = {
        "midia": 1,
        "colecionaveis": 2,
        "jardinagem": 3,
        "livrosehqs": 4,
        "informatica": 5
      }

      let categorias_nome = {
        "midia": "Mídia",
        "colecionaveis": "Colecionáveis",
        "jardinagem": "Jardinagem",
        "livrosehqs": "Livros e HQs",
        "informatica": "Informática"
      }

      this.categoria = categorias_nome[this.id as keyof typeof categorias_nome]

      fetch('http://localhost:8080/api/troca/categoria/' + categorias_id[this.id as keyof typeof categorias_id], {
        method: 'GET',
        headers: { 
          'Accept': 'application/json', 
          'Content-Type': 'application/json', 
          'Authorization': `${localStorage.getItem('token')}` 
        },
      })
      .then(response => response.json())
      .then((data) => {
        this.trocas = data;
      })
    });
  }
}
