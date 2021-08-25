import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { ApiModule } from './gen/api.module';
import { BASE_PATH } from './gen/variables';
import { PanelComponent } from './common/panel.component';
import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';

import { SidebarComponent } from './common/sidebar.component';
import { LoginFormComponent } from './login-form/login-form.component';
import { VehicleOwnerViewComponent } from './vehical-owner/vehicle-owner-view/vehicle-owner-view.component';
import { VehicleOwnerFormComponent } from './vehical-owner/vehicle-owner-form/vehicle-owner-form.component';
import { VehicleOwnerCrudComponent } from './vehical-owner/vehicle-owner-crud/vehicle-owner-crud.component';
import { PumpShopOverviewComponent } from './pump-shop/pump-shop-overview/pump-shop-overview.component';
import { PumpShopDetailViewComponent } from './pump-shop/pump-shop-detail-view/pump-shop-detail-view.component';

@NgModule({
	declarations: [
		AppComponent,
		PanelComponent,
		SidebarComponent,
		LoginFormComponent,
		VehicleOwnerViewComponent,
		VehicleOwnerFormComponent,
		VehicleOwnerCrudComponent,
		PumpShopOverviewComponent,
		PumpShopDetailViewComponent
	],

	imports: [
		ApiModule,
		BrowserModule,
		AppRoutingModule,
		FormsModule,
		ReactiveFormsModule,
		HttpClientModule
	],

	providers: [
		HttpClientModule,
		{provide: BASE_PATH, useValue: 'api'}
	],

	bootstrap: [AppComponent],
})

export class AppModule {

}

