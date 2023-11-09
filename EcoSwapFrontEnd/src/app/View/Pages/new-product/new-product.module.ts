import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';


import { NewProductRoutingModule } from './new-product-routing.module';
import { NewProductComponent } from './new-product.component';

@NgModule({
  declarations: [NewProductComponent],
  imports: [
    CommonModule,
    NewProductRoutingModule
  ]
})
export class NewProductModule { }
