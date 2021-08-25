import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginFormComponent } from './login-form/login-form.component';
import { VehicleOwnerViewComponent } from './vehical-owner/vehicle-owner-view/vehicle-owner-view.component';
import { VehicleOwnerFormComponent } from './vehical-owner/vehicle-owner-form/vehicle-owner-form.component';
import { PumpShopOverviewComponent } from './pump-shop/pump-shop-overview/pump-shop-overview.component';
import { PumpShopDetailViewComponent } from './pump-shop/pump-shop-detail-view/pump-shop-detail-view.component';

const routes: Routes = [
	{ path: '', redirectTo: '/login', pathMatch: 'full' },
	{ path: 'login', component: LoginFormComponent },
	{ path: 'vehicleOwners', component: VehicleOwnerViewComponent },
	{ path: 'vehicleOwners/new', component: VehicleOwnerFormComponent },
	{ path: 'vehicleOwners/detail', component: VehicleOwnerFormComponent },
	{ path: 'pumpShops', component: PumpShopOverviewComponent },
	{ path: 'pumpShops/detail', component: PumpShopDetailViewComponent },
	{ path: 'pumpShops/new', component: PumpShopDetailViewComponent }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
