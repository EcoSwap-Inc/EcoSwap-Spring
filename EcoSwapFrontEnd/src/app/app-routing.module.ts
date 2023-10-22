import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [{
    path: '',
    pathMatch: 'full',
    redirectTo: 'home'
  },
  {
    path: 'profile',
    loadChildren: () =>
      import('./View/Pages/home.module').then((m) => m.HomeModule),
  }];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
