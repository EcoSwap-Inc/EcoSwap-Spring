import { Component, Input } from '@angular/core';

@Component({
  selector: 'proposal-cards',
  templateUrl: './proposal-cards.component.html',
  styleUrls: ['./proposal-cards.component.css'],
})
export class ProposalCardsComponent {
  @Input() proposta!: any;
  rating!: number;
  imagem!: string;

  ngOnInit() {
    fetch("http://localhost:8080/api/avaliacao/mediaPropostas/" + this.proposta.usuario.id_usuario, {
      method: 'GET',
      headers: { 
        'Accept': 'application/json', 
        'Content-Type': 'application/json',
        'Authorization': `${localStorage.getItem('token')}` 
      },
    })
    .then(response => response.json())
    .then((data) => {
      this.rating = data.resultado;
    })
  }

  aceitarProposta() {
    this.proposta.aceito = true;
    fetch('http://localhost:8080/api/proposta/' + this.proposta.id_proposta, {
      method: 'PUT',
      headers: { 'Accept': 'application/json', 'Content-Type': 'application/json' },
      body: JSON.stringify({
        aceito: true
      })
    })
    .then(response => response)
    .then((data) => {
      // if (data.status == 200)
      //   this.router.navigateByUrl('/inventory')
      // else {
      //   alert("Erro: " + data.status + "\nPor favor revise os dados inseridos e garanta que são válidos, e que está conectado à internet.")
      // }
    })
  }
  
  negarProposta() {
    this.proposta.aceito = false;
    fetch('http://localhost:8080/api/proposta/' + this.proposta.id_proposta, {
      method: 'PUT',
      headers: { 'Accept': 'application/json', 'Content-Type': 'application/json' },
      body: JSON.stringify({
        aceito: false
      })
    })
    .then(response => response)
    .then((data) => {
      // if (data.status == 200)
      //   this.router.navigateByUrl('/inventory')
      // else {
      //   alert("Erro: " + data.status + "\nPor favor revise os dados inseridos e garanta que são válidos, e que está conectado à internet.")
      // }
    })
  }
}
