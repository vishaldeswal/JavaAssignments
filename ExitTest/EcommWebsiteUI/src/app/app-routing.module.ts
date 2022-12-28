import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddNewProductComponent } from './add-new-product/add-new-product.component';
import { AdminComponent } from './admin/admin.component';
import { BuyProductResolverService } from './buy-product-resolver.service';
import { BuyProductComponent } from './buy-product/buy-product.component';
import { ForbiddenComponent } from './forbidden/forbidden.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { OrderConfirmationComponent } from './order-confirmation/order-confirmation.component';
import { ProductResolveService } from './product-resolve.service';
import { ProductViewDetailsComponent } from './product-view-details/product-view-details.component';
import { RegisterVendorComponent } from './register-vendor/register-vendor.component';
import { RegisterComponent } from './register/register.component';
import { ReportComponent } from './report/report.component';
import { ShowProductDetailsComponent } from './show-product-details/show-product-details.component';

import { UserComponent } from './user/user.component';
import { VendorComponent } from './vendor/vendor.component';
import { AuthGuard } from './_auth/auth.guard';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'admin', component: AdminComponent, canActivate: [AuthGuard], data: { roles: ['Admin'] } },
  { path: 'vendor', component: VendorComponent, canActivate: [AuthGuard], data: { roles: ['Vendor'] } },
  { path: 'user', component: UserComponent, canActivate: [AuthGuard], data: { roles: ['User'] } },
  { path: 'login', component: LoginComponent },
  { path: 'forbidden', component: ForbiddenComponent },
  { path: 'report', component: ReportComponent, canActivate: [AuthGuard], data: { roles: ['Vendor'] } },
  {
    path: 'addNewProduct', component: AddNewProductComponent, canActivate: [AuthGuard], data: { roles: ['Vendor', 'Admin'] }, resolve: {
      product: ProductResolveService
    }
  },
  { path: 'showProductDetails', component: ShowProductDetailsComponent, canActivate: [AuthGuard], data: { roles: ['Vendor', 'Admin'] } },
  { path: 'productViewDetails', component: ProductViewDetailsComponent, resolve: { product: ProductResolveService } },
  {
    path: 'buyProduct', component: BuyProductComponent, canActivate: [AuthGuard], data: { roles: ['User'] }, resolve: {
      productDetails: BuyProductResolverService
    }
  },
  {
    path:'orderConfirm', component: OrderConfirmationComponent, canActivate: [AuthGuard], data: { roles: ['User'] }
  },
  {
    path:'register', component: RegisterComponent
  },
  {
    path:'registerVendor', component: RegisterVendorComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
