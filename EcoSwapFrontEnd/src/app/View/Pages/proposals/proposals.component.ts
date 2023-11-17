import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'proposals',
  templateUrl: './proposals.component.html',
  styleUrls: ['./proposals.component.css']
})
export class ProposalsComponent {
  troca: any;
  propostas: any;

  constructor(private route: ActivatedRoute) {
    route.params.subscribe(() => {
      let id = this.route.snapshot.paramMap.get('id');
      fetch("http://localhost:8080/api/troca/" + id, {
        method: 'GET',
        headers: { 
          'Accept': 'application/json', 
          'Content-Type': 'application/json',
          'Authorization': `${localStorage.getItem('token')}` 
        },
      })
      .then(response => response.json())
      .then((data) => {
        this.troca = data;
      })

      fetch("http://localhost:8080/api/proposta/troca/" + id, {
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
        console.log(data)
      })
    }) 
  }
}
