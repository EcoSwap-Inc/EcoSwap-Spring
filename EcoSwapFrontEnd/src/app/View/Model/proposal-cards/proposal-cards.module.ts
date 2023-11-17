import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ProposalCardsComponent } from './proposal-cards.component';

@NgModule({
  declarations: [
    ProposalCardsComponent
  ],
  imports: [
    CommonModule
    
  ],
  exports: [
    ProposalCardsComponent
  ]
  
})
export class ProposalCardsModule { }
