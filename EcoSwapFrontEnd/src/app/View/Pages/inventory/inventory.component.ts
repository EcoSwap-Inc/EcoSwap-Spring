import { Component } from '@angular/core';

@Component({
  selector: 'app-inventory',
  templateUrl: './inventory.component.html',
  styleUrls: ['./inventory.component.css']
})
export class InventoryComponent {
  produtos: any = [];
  produtoSelecionado: any = null;
  existeTroca!: any;

  constructor() {
    fetch('http://localhost:8080/api/produto/usuario/' + localStorage.getItem('user_id'), {
      method: 'GET',
      headers: { 
        'Accept': 'application/json', 
        'Content-Type': 'application/json', 
        'Authorization': `${localStorage.getItem('token')}` 
      },
    })
    .then(response => response.json())
    .then((data) => {
      this.produtos = data;
    })
  }

  selecionarProduto(produto: any) {
    fetch('http://localhost:8080/api/troca/existe/' + produto.id, {
      method: 'GET',
      headers: { 
        'Accept': 'application/json', 
        'Content-Type': 'application/json', 
        'Authorization': `${localStorage.getItem('token')}` 
      },
    })
    .then(response => response.json())
    .then((data) => {
      this.produtoSelecionado = produto;
      this.existeTroca = data;
    })
  }

  publicarTroca() {
    if (!this.existeTroca)
      fetch('http://localhost:8080/api/troca/', {
        method: 'POST',
        headers: { 
          'Accept': 'application/json', 
          'Content-Type': 'application/json', 
          'Authorization': `${localStorage.getItem('token')}` 
        },
        body: JSON.stringify({
          usuario: this.produtoSelecionado.usuario,
          produto: this.produtoSelecionado,
          finalizada: false, 
        })
      })
      .then(response => response.json())
      .then((data) => {
        this.existeTroca = true;
      })
  }
}
