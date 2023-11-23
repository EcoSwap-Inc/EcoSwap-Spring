import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { LogCardsComponent } from './log-cards.component';

@NgModule({
  declarations: [
    LogCardsComponent
  ],
  imports: [
    CommonModule
    
  ],
  exports: [
    LogCardsComponent
  ]
  
})
export class LogCardsModule { }
