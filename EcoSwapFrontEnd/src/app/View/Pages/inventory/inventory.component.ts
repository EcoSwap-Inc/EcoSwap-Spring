import { Component } from '@angular/core';

@Component({
  selector: 'app-inventory',
  templateUrl: './inventory.component.html',
  styleUrls: ['./inventory.component.css']
})
export class InventoryComponent {
  produtos: any = [];
  produtoSelecionado: any = null;

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
    this.produtoSelecionado = produto
  }
}
