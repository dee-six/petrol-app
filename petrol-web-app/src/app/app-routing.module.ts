import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { VehicleOwnerViewComponent } from './vehical-owner/vehicle-owner-view/vehicle-owner-view.component';
import { VehicleOwnerFormComponent } from './vehical-owner/vehicle-owner-form/vehicle-owner-form.component';
import { PumpShopViewComponent } from './pump-shop/pump-shop-view/pump-shop-view.component';
import { LoginFormComponent } from './login-form/login-form.component';
const routes: Routes = [
	{ path: '', redirectTo: '/login', pathMatch: 'full' },
	{ path: 'login', component: LoginFormComponent },
	{ path: 'vehicleOwners', component: VehicleOwnerViewComponent },
	{ path: 'vehicleOwners/new', component: VehicleOwnerFormComponent },
	{ path: 'vehicleOwners/detail', component: VehicleOwnerFormComponent },
	{ path: 'pumpShops', component: PumpShopViewComponent }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
