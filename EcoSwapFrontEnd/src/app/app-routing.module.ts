import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './View/Pages/login/login.component';

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
    path: 'main',
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
  {
    path: 'newproduct',
    loadChildren: () =>
      import('./View/Pages/new-product/new-product.module').then((m) => m.NewProductModule),
  },
  //Midia - categoria
  {
    path: 'category/:midia',
    loadChildren: () =>
      import('./View/Pages/category-catalogue/category-catalogue.module').then((m) => m.CategoryCatalogueModule),
  },
  //Midia - Livros e HQ's
  {
    path: 'category/:livrosehqs',
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
  },
  {
    path: 'swap',
      loadChildren: () =>
        import('./View/Pages/swap-page/swap-page.module').then((m) => m.SwapPageModule),
  },
  {
    path: 'info',
      loadChildren: () =>
        import('./View/Pages/product-info/product-info.module').then((m) => m.ProductInfoModule),
  },
  {
    path: 'history',
      loadChildren: () =>
        import('./View/Pages/swap-log/swap-log.module').then((m) => m.SwapLogModule),
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
