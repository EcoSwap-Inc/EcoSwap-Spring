import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [{
    path: '',
    pathMatch: 'full',
    redirectTo: 'login'
  },
  {
    path: 'login',
    loadChildren: () =>
      import('./View/Pages/login/login.module').then((m) => m.LoginModule),
  },
  {
    path: 'signup',
    loadChildren: () =>
      import('./View/Pages/sign-up/sign-up.module').then((m) => m.SignUpModule),
  },
  {
    path: 'home',
    loadChildren: () =>
      import('./View/Pages/main-catalogue/main-catalogue.module').then((m) => m.MainCatalogueModule),
  },
  {
    path: 'profile',
    loadChildren: () =>
      import('./View/Pages/profile-page/profile-page.module').then((m) => m.ProfilePageModule),
  },
  {
    path: 'inventory',
    loadChildren: () =>
      import('./View/Pages/inventory/inventory.module').then((m) => m.InventoryModule),
  },
  {
    path: 'editproduct',
    loadChildren: () =>
      import('./View/Pages/edit-product/edit-product.module').then((m) => m.EditProductModule),
  },
  //Midia - categoria
  {
    path: 'category/:midia',
    loadChildren: () =>
      import('./View/Pages/category-catalogue/category-catalogue.module').then((m) => m.CategoryCatalogueModule),
  },
  //Colecionaveis- categoria
  {
    path: 'category/:colecionaveis',
    loadChildren: () =>
      import('./View/Pages/category-catalogue/category-catalogue.module').then((m) => m.CategoryCatalogueModule),
  },
  //Jardinagem - categoria
  {
    path: 'category/:jardinagem',
    loadChildren: () =>
      import('./View/Pages/category-catalogue/category-catalogue.module').then((m) => m.CategoryCatalogueModule),
  },
  //Informática - categoria
  {
    path: 'category/:informatica',
    loadChildren: () =>
      import('./View/Pages/category-catalogue/category-catalogue.module').then((m) => m.CategoryCatalogueModule),
  },
  {
  path: 'editinfo',
    loadChildren: () =>
      import('./View/Pages/edit-info/edit-info.module').then((m) => m.EditInfoModule),
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
