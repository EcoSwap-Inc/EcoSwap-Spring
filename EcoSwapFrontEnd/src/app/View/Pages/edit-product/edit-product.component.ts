import { Component } from '@angular/core';
import { FormControl } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-edit-product',
  templateUrl: './edit-product.component.html',
  styleUrls: ['./edit-product.component.css']
})
export class EditProductComponent {
  produto: any;
  id: string | null;

  nome: FormControl = new FormControl();  
  descricao: FormControl = new FormControl();

  constructor(private router: Router, private route: ActivatedRoute) {
    this.id = this.route.snapshot.paramMap.get('id');
    
    fetch('http://localhost:8080/api/produto/' + this.id, {
      method: 'GET',
      headers: { 
        'Accept': 'application/json', 
        'Content-Type': 'application/json', 
        'Authorization': `${localStorage.getItem('token')}` 
      },
    })
    .then(response => response.json())
    .then((data) => {
      this.produto = data;
      this.nome.setValue(data.nome);
      this.descricao.setValue(data.descricao)
    });
  }

  salvarAlteracoes() {
    this.produto.nome = this.nome.value;
    this.produto.descricao = this.descricao.value;
    console.log(this.produto);

    fetch('http://localhost:8080/api/produto/' + this.id, {
      method: 'PUT',
      headers: { 'Accept': 'application/json', 'Content-Type': 'application/json' },
      body: JSON.stringify(this.produto)
    })
    .then(response => response)
    .then((data) => {
      if (data.status == 200)
        this.router.navigateByUrl('/inventory')
      else {
        alert("Erro: " + data.status + "\nPor favor revise os dados inseridos e garanta que são válidos, e que está conectado à internet.")
      }
    })
  }
}
