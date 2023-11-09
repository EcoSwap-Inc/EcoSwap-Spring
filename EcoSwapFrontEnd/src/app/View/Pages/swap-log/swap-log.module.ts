import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SwapLogRoutingModule } from './swap-log-routing.module';
import { SwapLogComponent } from './swap-log.component';

import { CardsModule } from '../../Model/cards/cards.module';

@NgModule({
  declarations: [SwapLogComponent],
  imports: [
    CommonModule,
    SwapLogRoutingModule,
    CardsModule
  ]
})
export class SwapLogModule { }
