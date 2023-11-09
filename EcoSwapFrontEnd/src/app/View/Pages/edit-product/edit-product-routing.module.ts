import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { EditProductComponent } from './edit-product.component';

const routes: Routes = [
  {
    path: '',
    component: EditProductComponent,
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class EditProductRoutingModule {}