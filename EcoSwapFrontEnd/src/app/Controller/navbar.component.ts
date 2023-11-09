import { Component, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-navbar',
  templateUrl: '../View/Components/navbar.component.html',
  styleUrls: ['../View/Style/navbar.component.css']
})
export class NavbarComponent {
    estadoPfpMenu: boolean = false;

    @Output() novoPfpMenuEstadoEvent = new EventEmitter<boolean>();

    changePfpMenuState () {
      this.estadoPfpMenu = !this.estadoPfpMenu;
      this.novoPfpMenuEstadoEvent.emit(this.estadoPfpMenu);
    }
}
