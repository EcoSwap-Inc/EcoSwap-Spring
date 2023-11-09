import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { SwapLogComponent } from './swap-log.component';

const routes: Routes = [
  {
    path: '',
    component: SwapLogComponent,
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class SwapLogRoutingModule {}