import { Component } from '@angular/core';


@Component({
  selector: 'app-header',
  templateUrl: '../View/Components/header.component.html',
  styleUrls: ['../View/Style/header.component.css']
})
export class HeaderComponent {
    menuAberto: boolean = false;

    changeMenuPfpMenuState (state: boolean) {
      this.menuAberto = state;
    }
}
