import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { ApiModule } from './gen/api.module';
import {BASE_PATH } from './gen/variables';
import { PanelComponent } from './common/panel.component';
import { SidebarComponent } from './common/sidebar.component';
import { VehicleOwnerViewComponent } from './vehical-owner/vehicle-owner-view/vehicle-owner-view.component';
import { VehicleOwnerFormComponent } from './vehical-owner/vehicle-owner-form/vehicle-owner-form.component';
import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { LoginFormComponent } from './login-form/login-form.component';
import { VehicleOwnerCrudComponent } from './vehical-owner/vehicle-owner-crud/vehicle-owner-crud.component';
import { PumpShopViewComponent } from './pump-shop/pump-shop-view/pump-shop-view.component';

@NgModule({
	declarations: [
		AppComponent,
		PanelComponent,
		SidebarComponent,
		VehicleOwnerViewComponent,
		VehicleOwnerFormComponent,
		PumpShopViewComponent,
		LoginFormComponent,
		VehicleOwnerCrudComponent
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

