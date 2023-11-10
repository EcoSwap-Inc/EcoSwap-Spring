import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ProductInfoComponent } from './product-info.component';
import { ProductInfoRoutingModule } from './product-info-routing.module';

@NgModule({
  declarations: [ProductInfoComponent],
  imports: [
    CommonModule,
    ProductInfoRoutingModule
  ]
})
export class ProductInfoModule { }
