import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { PanelComponent } from './common/panel.component';
import { SidebarComponent } from './common/sidebar.component';
import { VehicleOwnerViewComponent } from './vehical-owner/vehicle-owner-view/vehicle-owner-view.component';
import { VehicleOwnerFormComponent } from './vehical-owner/vehicle-owner-form/vehicle-owner-form.component';
import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { LoginFormComponent } from './login-form/login-form.component';
import { VehicleOwnerCrudComponent } from './vehical-owner/vehicle-owner-crud/vehicle-owner-crud.component';


@NgModule({
  declarations: [
	  PanelComponent,
	  SidebarComponent,
	  VehicleOwnerViewComponent,
    AppComponent,
    VehicleOwnerFormComponent,
    LoginFormComponent,
    VehicleOwnerCrudComponent
  ],

  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],

  providers: [
    HttpClientModule
  ],
  bootstrap: [AppComponent]
})

export class AppModule { 
	
}

