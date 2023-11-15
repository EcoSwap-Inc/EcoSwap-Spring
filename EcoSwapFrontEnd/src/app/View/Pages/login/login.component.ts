import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  showAlert(){
    window.alert("Entre em contato com o suporte");
  }
  
  constructor ( private router: Router ) {}
  
  login(emailField: HTMLInputElement, senhaField: HTMLInputElement) {
    fetch('http://localhost:8080/api/auth/login', {
      method: 'POST',
      headers: { 'Accept': 'application/json', 'Content-Type': 'application/json' },
      body: JSON.stringify({email: emailField.value, senha: senhaField.value})
    })
    .then(response => response.json())
    .then((data) => {
      localStorage.setItem('token', data.token);

      this.router.navigateByUrl('/main')
    })

  }
}
