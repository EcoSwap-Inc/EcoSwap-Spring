import { Component } from '@angular/core';

@Component({
  selector: 'app-profile-page',
  templateUrl: './profile-page.component.html',
  styleUrls: ['./profile-page.component.css']
})
export class ProfilePageComponent {
  usuario: any = {nome: 'User', cidade: 'Cidade', uf: 'SP', email: 'email@email.com', telefone: '000000000000'};

  constructor() {
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
    });
  }
}
