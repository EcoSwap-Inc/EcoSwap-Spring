import { Component } from '@angular/core';
import { Router, NavigationEnd, RouterOutlet } from '@angular/router';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']

})
export class AppComponent {
  notificacoes: Array<Object> = [];

  title = 'EcoSwapFrontEnd';

  showHeader: boolean = true;
  showFooter: boolean = true;

  constructor(private router: Router){
    this.router.events.subscribe((event) => {
      if(event instanceof NavigationEnd){
          const curRoute = event.url;
          if(curRoute === '/login' || curRoute === '/signup' || curRoute === '/'){
            this.showHeader = false;
            this.showFooter = false;
          }
          else{
            this.showFooter = true;
            this.showHeader = true;

            fetch('http://localhost:8080/api/proposta/notificacoes/' + localStorage.getItem('user_id'), {
              method: 'GET',
              headers: { 
                'Accept': 'application/json', 
                'Content-Type': 'application/json', 
                'Authorization': `${localStorage.getItem('token')}` 
              },
            })
            .then(response => response.json())
            .then((data) => {
              this.notificacoes = data;
            })
          }
      }
    })
  }

  
}
