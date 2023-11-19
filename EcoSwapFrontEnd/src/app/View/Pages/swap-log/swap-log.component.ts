import { Component } from '@angular/core';

@Component({
  selector: 'app-swap-log',
  templateUrl: './swap-log.component.html',
  styleUrls: ['./swap-log.component.css']
})
export class SwapLogComponent {
  propostas: any;

  constructor() {
    fetch("http://localhost:8080/api/proposta/finalizadas/" + localStorage.getItem('user_id'), {
      method: 'GET',
      headers: { 
        'Accept': 'application/json', 
        'Content-Type': 'application/json',
          'Authorization': `${localStorage.getItem('token')}` 
      },
    })
    .then(response => response.json())
    .then((data) => {
      this.propostas = data;
    })
  }
}
