import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { EditInfoRoutingModule } from './edit-info-routing.module';
import {EditInfoComponent } from './edit-info.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [EditInfoComponent],
  imports: [
    CommonModule,
    EditInfoRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ]
})
export class EditInfoModule { }
