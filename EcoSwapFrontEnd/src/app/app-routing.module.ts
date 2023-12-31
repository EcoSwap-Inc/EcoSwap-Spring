import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuard } from './auth.guard';


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
    canActivate: [AuthGuard],

  },
  {
    path: 'profile',
    loadChildren: () =>
      import('./View/Pages/profile-page/profile-page.module').then((m) => m.ProfilePageModule),
    canActivate: [AuthGuard],

  },
  {
    path: 'inventory',
    loadChildren: () =>
      import('./View/Pages/inventory/inventory.module').then((m) => m.InventoryModule),
    canActivate: [AuthGuard],
  },
  {
    path: 'editproduct',
    loadChildren: () =>
      import('./View/Pages/edit-product/edit-product.module').then((m) => m.EditProductModule),
    canActivate: [AuthGuard],
  },
  {
    path: 'newproduct',
    loadChildren: () =>
      import('./View/Pages/new-product/new-product.module').then((m) => m.NewProductModule),
      canActivate: [AuthGuard],
  },
  {
    path: 'category/:id',
    loadChildren: () =>
      import('./View/Pages/category-catalogue/category-catalogue.module').then((m) => m.CategoryCatalogueModule),
    canActivate: [AuthGuard],
  },
  {
  path: 'editinfo',
    loadChildren: () =>
      import('./View/Pages/edit-info/edit-info.module').then((m) => m.EditInfoModule),
    canActivate: [AuthGuard],
  },
  {
    path: 'editproduct/:id',
      loadChildren: () =>
        import('./View/Pages/edit-product/edit-product.module').then((m) => m.EditProductModule),
      canActivate: [AuthGuard],
    },
  {
    path: 'swap/:id',
      loadChildren: () =>
        import('./View/Pages/swap-page/swap-page.module').then((m) => m.SwapPageModule),
    canActivate: [AuthGuard],
  },
  {
    path: 'info/:id',
      loadChildren: () =>
        import('./View/Pages/product-info/product-info.module').then((m) => m.ProductInfoModule),
    canActivate: [AuthGuard],
  },
  {
    path: 'history',
      loadChildren: () =>
        import('./View/Pages/swap-log/swap-log.module').then((m) => m.SwapLogModule),
    canActivate: [AuthGuard],
  },
  {
    path: 'propostas/:id',
    loadChildren: () =>
      import('./View/Pages/proposals/proposals.module').then((m) => m.ProposalsModule),
    canActivate: [AuthGuard],

  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
