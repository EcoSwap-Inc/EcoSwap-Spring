import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'log-cards',
  templateUrl: './log-cards.component.html',
  styleUrls: ['./log-cards.component.css'],
})
export class LogCardsComponent {
  @Input() produto!: any;
  @Input() proposta!: any;
  @Input() tipo!: any;
  @Input() index: any = 0;
  @Output() changeRating = new EventEmitter<[number, number]>();

  @Output() avaliacao = new EventEmitter<[number, number]>();
  rating: number = 0;
  imagem!: string;

  ngOnInit() {
    try {
    if (this.tipo)
      
      fetch(`http://localhost:8080/api/avaliacao/${this.proposta.id_proposta}/${this.proposta.troca.id}`, {
        method: 'GET',
        headers: { 
          'Accept': 'application/json', 
          'Content-Type': 'application/json',
          'Authorization': `${localStorage.getItem('token')}` 
        }
      })
      .then(response => response.json())
      .then((data) => {
        this.rating = data.avaliacao_proposta;
        this.changeRating.emit([this.index, this.rating])
      })
    else
      fetch(`http://localhost:8080/api/avaliacao/${this.proposta.id_proposta}/${this.proposta.troca.id}`, {
        method: 'GET',
        headers: { 
          'Accept': 'application/json', 
          'Content-Type': 'application/json',
          'Authorization': `${localStorage.getItem('token')}` 
        }
      })
      .then(response => response.json())
      .then((data) => {
        this.rating = data.avaliacao_troca;
        this.changeRating.emit([this.index, this.rating])
      })
    } catch {

    }
    

  }

  avaliar(nota: number) {
    this.rating = nota;
    this.avaliacao.emit([nota, this.index]) 
  }
}

