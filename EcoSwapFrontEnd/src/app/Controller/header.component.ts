import { Component, Input } from '@angular/core';
import { ActivatedRoute, NavigationEnd, Router } from '@angular/router';


@Component({
  selector: 'app-header',
  templateUrl: '../View/Components/header.component.html',
  styleUrls: ['../View/Style/header.component.css']
})
export class HeaderComponent {
    menuAberto: boolean = false;
    @Input() notificacoes: any;

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
      localStorage.removeItem('user_id');

      this.router.navigateByUrl('/login');
    }
}
