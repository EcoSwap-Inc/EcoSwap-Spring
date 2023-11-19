import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-navbar',
  templateUrl: '../View/Components/navbar.component.html',
  styleUrls: ['../View/Style/navbar.component.css']
})
export class NavbarComponent {
    estadoPfpMenu: boolean = false;

    @Output() novoPfpMenuEstadoEvent = new EventEmitter<boolean>();
    @Input() notificacoes: any = [];

    changePfpMenuState () {
      this.estadoPfpMenu = !this.estadoPfpMenu;
      this.novoPfpMenuEstadoEvent.emit(this.estadoPfpMenu);
    }

    //notificações
    estadoNotif: boolean = false;

    @Output() novoNotifEvent = new EventEmitter<boolean>();

    changeNotifState () {
      this.estadoNotif = !this.estadoNotif;
      this.novoNotifEvent.emit(this.estadoNotif);
    }
}
