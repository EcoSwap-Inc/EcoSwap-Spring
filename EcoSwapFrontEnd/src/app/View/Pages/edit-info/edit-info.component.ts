import { Component } from '@angular/core';
import { FormControl } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-edit-info',
  templateUrl: './edit-info.component.html',
  styleUrls: ['./edit-info.component.css']
})
export class EditInfoComponent {
  usuario: any;

  telefone: FormControl = new FormControl<number | undefined>(undefined);
  cep: FormControl = new FormControl<number | undefined>(undefined);
  UF: FormControl = new FormControl();
  cidade: FormControl = new FormControl();
  rua: FormControl = new FormControl();
  numero_rua: FormControl = new FormControl<number | undefined>(undefined);
  complemento: FormControl = new FormControl();

  constructor(private router: Router) {
    fetch('http://localhost:8080/api/usuario/' + localStorage.getItem('user_id'), {
      method: 'GET',
      headers: { 
        'Accept': 'application/json', 
        'Content-Type': 'application/json', 
        'Authorization': `${localStorage.getItem('token')}` 
      },
    })
    .then(response => response.json())
    .then((data) => {
      this.usuario = data;
      this.telefone.setValue(data.telefone);
      this.UF.setValue(data.uf)
      this.cidade.setValue(data.cidade)
      this.rua.setValue(data.rua)
      this.numero_rua.setValue(data.numero_rua)
      this.complemento.setValue(data.complemento)
      this.cep.setValue(data.cep)
    });
  }

  salvarAlteracoes() {
    this.usuario.cidade = this.cidade.value;
    this.usuario.rua = this.rua.value;
    this.usuario.numero_rua = this.numero_rua.value;
    this.usuario.complemento = this.complemento.value;
    this.usuario.cep = this.cep.value;
    this.usuario.uf = this.UF.value;
    this.usuario.telefone = this.telefone.value;

    fetch('http://localhost:8080/api/usuario/' + localStorage.getItem('user_id'), {
      method: 'PUT',
      headers: { 'Accept': 'application/json', 'Content-Type': 'application/json' },
      body: JSON.stringify(this.usuario)
    })
    .then(response => response)
    .then((data) => {
      if (data.status == 200)
        this.router.navigateByUrl('/profile')
      else {
        alert("Erro: " + data.status + "\nPor favor revise os dados inseridos e garanta que são válidos, e que está conectado à internet.")
      }
    })
  }
}
