import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BannerComponent } from './banner.component';
import { HeaderComponent } from './header.component';
import { NavbarComponent } from './navbar.component';



@NgModule({
  declarations: [
    HeaderComponent,
    BannerComponent,
    NavbarComponent
  ],
  imports: [
    CommonModule
  ],
  exports: [
    HeaderComponent
  ]
})
export class HeaderModule { }
