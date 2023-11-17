import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-swap-page',
  templateUrl: './swap-page.component.html',
  styleUrls: ['./swap-page.component.css']
})
export class SwapPageComponent {
  produtos: any = [];
  produtoDesejado: any = {nome: "", descricao: "", usuario: {nome: "", cidade: "", uf: ""}, categoria: {nome: ""}};
  troca: any;
  produtoSelecionado: any = {nome: "", descricao: "", usuario: {nome: "", cidade: "", uf: ""}, categoria: {nome: ""}};

  constructor(private route: ActivatedRoute, private router: Router) {
    fetch('http://localhost:8080/api/troca/' + this.route.snapshot.paramMap.get('id'), {
      method: 'GET',
      headers: { 
        'Accept': 'application/json',
        'Content-Type': 'application/json',
        'Authorization': `${localStorage.getItem('token')}`
      },
    })
    .then(response => response.json())
    .then((data) => {
      this.troca = data;
      this.produtoDesejado = data.produto;
    })

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
      if (this.produtos.length > 0)
        this.produtoSelecionado = this.produtos[0];
    })
  }

  selecionarProduto(evento: any) {
    this.produtoSelecionado = this.produtos[evento.target.value];
  }

  fazerProposta() {
    fetch('http://localhost:8080/api/proposta/', {
      method: 'POST',
      headers: { 'Accept': 'application/json', 'Content-Type': 'application/json', 'Authorization': `${localStorage.getItem('token')}` },
      body: JSON.stringify({
        usuario: this.produtoSelecionado.usuario,
        troca: this.troca,
        produto: this.produtoSelecionado,
      })
    })
    .then(response => response.json())
    .then((data) => {
      if (data.status == '201')
        this.router.navigateByUrl('inventory');
      else 
        alert("Erro: " + data.status + "\nPor favor revise os dados inseridos e garanta que são válidos, e que está conectado à internet.")
    })
  }
}
