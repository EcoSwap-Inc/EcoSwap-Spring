import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { MainCatalogueRoutingModule } from './main-catalogue-routing.module';
import { MainCatalogueComponent } from './main-catalogue.component';

import { CardsModule } from '../../Model/cards/cards.module';

@NgModule({
  declarations: [MainCatalogueComponent],
  imports: [
    CommonModule,
    MainCatalogueRoutingModule,
    CardsModule
  ]
})
export class MainCatalogueModule { }
