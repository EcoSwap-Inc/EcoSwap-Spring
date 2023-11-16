import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';


import { NewProductRoutingModule } from './new-product-routing.module';
import { NewProductComponent } from './new-product.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';


@NgModule({
  declarations: [NewProductComponent],
  imports: [
    CommonModule,
    NewProductRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ]
})
export class NewProductModule { }
