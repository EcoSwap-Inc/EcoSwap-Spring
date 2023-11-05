import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { MainCatalogueComponent } from './main-catalogue.component';

const routes: Routes = [
  {
    path: '',
    component: MainCatalogueComponent,
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class MainCatalogueRoutingModule {}