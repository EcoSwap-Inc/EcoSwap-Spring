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
    let valores: any = {
      cidade: this.cidade.value,
      rua: this.rua.value,
      numero_rua: this.numero_rua.value,
      complemento: this.complemento.value,
      cep: this.cep.value,
      uf: this.UF.value,
      telefone: this.telefone.value,
    }

    fetch('http://localhost:8080/api/usuario/' + localStorage.getItem('user_id'), {
      method: 'PUT',
      headers: { 'Accept': 'application/json', 'Content-Type': 'application/json' },
      body: JSON.stringify(valores)
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
