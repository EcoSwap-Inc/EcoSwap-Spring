import { Component } from '@angular/core';
import { Router, NavigationEnd, RouterOutlet } from '@angular/router';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']

})
export class AppComponent {
 

  title = 'EcoSwapFrontEnd';

  showHeader: boolean = true;
  showFooter: boolean = true;

  constructor(private router:Router){
    router.events.subscribe((event) => {
      if(event instanceof NavigationEnd){
          const curRoute = event.url;
          if(curRoute === '/login' || curRoute === '/signup' || curRoute === '/'){
            this.showHeader = false;
            this.showFooter = false;
          }
          else{
            this.showFooter = true;
            this.showHeader = true;
          }
      }
    })
  }

  
}
