import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ProposalsRoutingModule } from './proposals-routing.module';
import { ProposalsComponent } from './proposals.component';
import { ProposalCardsModule } from '../../Model/proposal-cards/proposal-cards.module';
import { ActivatedRoute, Params } from '@angular/router';

@NgModule({
  declarations: [ProposalsComponent],
  imports: [
    CommonModule,
    ProposalsRoutingModule,
    ProposalCardsModule
  ]
})
export class ProposalsModule { 
}
