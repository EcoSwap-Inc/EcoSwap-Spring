import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SwapLogRoutingModule } from './swap-log-routing.module';
import { SwapLogComponent } from './swap-log.component';
import { LogCardsModule } from '../../Model/log-cards/log-cards.module';



@NgModule({
  declarations: [SwapLogComponent],
  imports: [
    CommonModule,
    SwapLogRoutingModule,
    LogCardsModule
  ]
})
export class SwapLogModule { }
