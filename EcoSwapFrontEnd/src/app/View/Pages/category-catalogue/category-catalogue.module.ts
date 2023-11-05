import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CategoryCatalogueRoutingModule } from './category-catalogue-routing.module';
import { CategoryCatalogueComponent } from './category-catalogue.component';

import { CardsModule } from '../../Model/cards/cards.module';


@NgModule({
  declarations: [CategoryCatalogueComponent],
  imports: [
    CommonModule,
    CardsModule,
    CategoryCatalogueRoutingModule
  ]
})
export class CategoryCatalogueModule { }
