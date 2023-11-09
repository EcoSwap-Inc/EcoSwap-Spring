import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { EditInfoRoutingModule } from './edit-info-routing.module';
import {EditInfoComponent } from './edit-info.component';

@NgModule({
  declarations: [EditInfoComponent],
  imports: [
    CommonModule,
    EditInfoRoutingModule
  ]
})
export class EditInfoModule { }
