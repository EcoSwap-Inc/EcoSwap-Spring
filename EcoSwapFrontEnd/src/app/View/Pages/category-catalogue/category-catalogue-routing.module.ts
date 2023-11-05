import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { CategoryCatalogueComponent } from './category-catalogue.component';

const routes: Routes = [
  {
    path: '',
    component: CategoryCatalogueComponent,
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class CategoryCatalogueRoutingModule {}