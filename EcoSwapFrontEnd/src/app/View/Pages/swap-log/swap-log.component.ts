import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-swap-log',
  templateUrl: './swap-log.component.html',
  styleUrls: ['./swap-log.component.css']
})
export class SwapLogComponent {
  propostas: any;
  avaliacaoProp: any = {};
  avaliacaoTroca: any = {};

  constructor() {
    fetch("http://localhost:8080/api/proposta/finalizadas/" + localStorage.getItem('user_id'), {
      method: 'GET',
      headers: { 
        'Accept': 'application/json', 
        'Content-Type': 'application/json',
        'Authorization': `${localStorage.getItem('token')}` 
      }
    })
    .then(response => response.json())
    .then((data) => {
      this.propostas = data;
    })
  }

  avaliar(index: any) {
    
    let proposta = this.propostas[index];
    console.log({
      usuario_proposta_id: proposta.usuario.id_usuario,
      usuario_troca_id: proposta.troca.usuario.id_usuario,
      troca_id: proposta.troca.id,
      proposta_id: proposta.id_proposta,
      avaliacao_proposta: this.avaliacaoProp[index],
      avaliacao_troca: this.avaliacaoTroca[index]
    })
    fetch("http://localhost:8080/api/avaliacao/", {
      method: 'POST',
      headers: { 
        'Accept': 'application/json', 
        'Content-Type': 'application/json',
        'Authorization': `${localStorage.getItem('token')}`
      },
      body: JSON.stringify({
        usuario_proposta_id: proposta.usuario.id_usuario,
        usuario_troca_id: proposta.troca.usuario.id_usuario,
        troca_id: proposta.troca.id,
        proposta_id: proposta.id_proposta,
        avaliacao_proposta: this.avaliacaoProp[index],
        avaliacao_troca: this.avaliacaoTroca[index]
      })
    })
    .then(response => response.json())
    .then((data) => {
    })
  }

  avaliarProposta(nota: any) {
    this.avaliacaoProp[nota[1]] = nota[0];
    this.avaliar(nota[1]);
  }

  avaliarTroca(nota: any) {
    this.avaliacaoTroca[nota[1]] = nota[0];
    this.avaliar(nota[1]);
  }

  mudarRatingProposta(nota: any)  {
    this.avaliacaoProp[nota[0]] = nota[1]
    console.log(nota)
  }

  mudarRatingTroca(nota: any)  {
    this.avaliacaoTroca[nota[0]] = nota[1]
    console.log(nota)
  }
}
