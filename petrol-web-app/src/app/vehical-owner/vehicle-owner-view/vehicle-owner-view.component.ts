import { Component, OnInit } from '@angular/core';

import { VehicleOwnerDto } from '../../gen/model/vehicleOwnerDto';
import { VehicleOwnerService } from '../../gen/api/vehicleOwner.service';
import { Observable } from 'rxjs';


@Component({
	selector: 'app-vehicle-owner-list',
	templateUrl: './vehicle-owner-view.component.html'
})

export class VehicleOwnerViewComponent implements OnInit {

	title = "Vehicle Owner's List";
	vehicleOwners: VehicleOwnerDto[] = [];
	colspan = 10;
	isActive = false;

	constructor(private vehicleService: VehicleOwnerService) {
		
	}

	onSave($event) {
		console.log("Save was clicked", $event);
	}

	getVehicleOwners() {

		if (this.vehicleOwners.length == 0) {
			this.vehicleService.findAll().subscribe((vehicleOwners: VehicleOwnerDto[]) => {
				this.vehicleOwners = vehicleOwners;
			})
			return this.vehicleOwners;
		}
	}

	getTitle() {
		return this.title;
	}

	onClick($event) {
		this.getVehicleOwners();
	}

	ngOnInit() {
		console.log("VehicleOwnerViewComponent constructor is called");
		console.log(this.vehicleService.configuration);

		this.vehicleService.findAll().subscribe((vehicleOwners: VehicleOwnerDto[]) => {
			this.vehicleOwners = vehicleOwners;
		})
	}
}


