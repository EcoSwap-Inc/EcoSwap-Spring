import { Component } from '@angular/core';
import { Router } from '@angular/router';


@Component({
  selector: 'app-header',
  templateUrl: '../View/Components/header.component.html',
  styleUrls: ['../View/Style/header.component.css']
})
export class HeaderComponent {
    menuAberto: boolean = false;

    constructor (private router: Router) {}

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
      this.router.navigateByUrl('/login');
    }
}
