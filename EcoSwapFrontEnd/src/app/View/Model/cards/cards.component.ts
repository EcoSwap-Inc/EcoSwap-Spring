import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-cards',
  templateUrl: './cards.component.html',
  styleUrls: ['./cards.component.css']
})
export class CardsComponent {
  @Input() produto!: any;
  rating!: number;

  counter(i: number) {
    if (i != 0)
      return new Array(i);
    else 
      return []
  }

  ngOnInit() {
   
    fetch("http://localhost:8080/api/avaliacao/mediaTrocas/" + this.produto.usuario.id_usuario, {
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
        console.log(data)
      })
  }
}
