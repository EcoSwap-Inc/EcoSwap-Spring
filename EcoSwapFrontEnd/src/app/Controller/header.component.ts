import { Component } from '@angular/core';
import { ActivatedRoute, NavigationEnd, Router } from '@angular/router';


@Component({
  selector: 'app-header',
  templateUrl: '../View/Components/header.component.html',
  styleUrls: ['../View/Style/header.component.css']
})
export class HeaderComponent {
    menuAberto: boolean = false;
    notificacoes: any = [];

    constructor (private router: Router, private route: ActivatedRoute) {
      this.router.events.subscribe((val) => {
        if (val instanceof NavigationEnd) 
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
        
        
      })
    }

    changeMenuPfpMenuState (state: boolean) {
      this.menuAberto = state;
    }

    //Notificações
    notifNav: boolean = false;

    changeNotifState (state: boolean) {
      this.notifNav = state;
    }

    deslogar() {
      localStorage.removeItem('token');
      localStorage.removeItem('user_id');

      this.router.navigateByUrl('/login');
    }
}
