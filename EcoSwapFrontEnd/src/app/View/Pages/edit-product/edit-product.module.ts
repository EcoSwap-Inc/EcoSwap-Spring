import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { EditProductRoutingModule } from './edit-product-routing.module';
import { EditProductComponent } from './edit-product.component';

@NgModule({
  declarations: [EditProductComponent],
  imports: [
    CommonModule,
    EditProductRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ]
})
export class EditProductModule { }
