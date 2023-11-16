import { Component, ViewChild } from '@angular/core';
import { FormControl } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-new-product',
  templateUrl: './new-product.component.html',
  styleUrls: ['./new-product.component.css']
})
export class NewProductComponent {
  nomeForm: FormControl = new FormControl();
  descricaoForm: FormControl = new FormControl();
  categoriaForm: FormControl = new FormControl();
  @ViewChild('imagemForm') imagemForm: any; 
  imagem: any = null;

  usuario: any;
  categoria: any;

  constructor(private router: Router) {}

  salvarProduto() {
    let token = localStorage.getItem('token')
    fetch('http://localhost:8080/api/usuario/' + localStorage.getItem('user_id'), {
      method: 'GET',
      headers: { 'Accept': 'application/json', 'Content-Type': 'application/json', 'Authorization': `${token}`  }
    })
    .then(response => response.json())
    .then((data) => {
      this.usuario = data;

      fetch('http://localhost:8080/api/categoria/' + this.categoriaForm.value, {
        method: 'GET',
        headers: { 'Accept': 'application/json', 'Content-Type': 'application/json', 'Authorization': `${token}`  }
      })
      .then(response => response.json())
      .then((data2) => {
        this.categoria = data2;

        let valores: any = {
          usuario: this.usuario,
          categoria: this.categoria,
          nome: this.nomeForm.value,
          descricao: this.descricaoForm.value,
          imagem: this.imagem
        };
        
        fetch('http://localhost:8080/api/produto/', {
          method: 'POST',
          headers: { 'Accept': 'application/json', 'Content-Type': 'application/json', 'Authorization': `${token}` },
          body: JSON.stringify(valores)
        })
        .then(response => response.json())
        .then((data3) => {
          if (data3.status == '201')
            this.router.navigateByUrl('inventory');
          else 
            alert("Erro: " + data3.status + "\nPor favor revise os dados inseridos e garanta que são válidos, e que está conectado à internet.")
        })
      })
    })
  }

  imagemToBase64(event: any) {
    if (!event.target.files) {
      this.imagem = null;
      return;
    }

    const file: File = event.target.files[0];
    const reader = new FileReader();
    reader.readAsDataURL(file);
    reader.onload = () => {
        this.imagem = reader.result;
        console.log(this.imagem)
    };

  }
}
