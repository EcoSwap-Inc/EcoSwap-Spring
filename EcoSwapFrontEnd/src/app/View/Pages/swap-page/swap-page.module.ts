import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SwapPageRoutingModule } from './swap-page-routing.module';
import { SwapPageComponent } from './swap-page.component';


@NgModule({
  declarations: [SwapPageComponent],
  imports: [
    CommonModule,
    SwapPageRoutingModule
  ]
})
export class SwapPageModule { }
