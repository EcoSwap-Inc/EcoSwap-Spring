import { Component, ViewChild } from '@angular/core';
import { FormGroup, FormControl, Validators, FormBuilder } from "@angular/forms";
import { Router } from '@angular/router';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent {
  


  passo: number = 0;

  nome: FormControl = new FormControl();
  dataNasc: FormControl = new FormControl();
  email: FormControl = new FormControl();
  telefone: FormControl = new FormControl<number | undefined>(undefined);  
  cep: FormControl = new FormControl<number | undefined>(undefined);
  UF: FormControl = new FormControl();
  cidade: FormControl = new FormControl();
  rua: FormControl = new FormControl();
  numero_rua: FormControl = new FormControl<number | undefined>(undefined);
  complemento: FormControl = new FormControl();
  senha: FormControl = new FormControl();
  senhaConfirmar: FormControl = new FormControl();
  
  constructor( private router: Router) {}

  proximoPasso() {
    this.passo++;
    
    if (this.passo >= 3) {
      let valores: any = {
        email: this.email.value,
        senha: this.senha.value,
        nome: this.nome.value,
        cidade: this.cidade.value,
        rua: this.rua.value,
        numero_rua: this.numero_rua.value,
        complemento: this.complemento.value,
        cep: this.cep.value,
        UF: this.UF.value,
        telefone: this.telefone.value,
        dataNasc: this.dataNasc.value
      }

      fetch('http://localhost:8080/api/auth/registrar', {
        method: 'POST',
        headers: { 'Accept': 'application/json', 'Content-Type': 'application/json' },
        body: JSON.stringify(valores)
      })
      .then(response => response)
      .then((data) => {
        if (data.status == 200)
          this.router.navigateByUrl('/login')
        else {
          alert("Erro: " + data.status + "\nPor favor revise os dados inseridos e garanta que são válidos, e que está conectado à internet.")
          this.passo = 0
        }
      })
    }
  }
}
