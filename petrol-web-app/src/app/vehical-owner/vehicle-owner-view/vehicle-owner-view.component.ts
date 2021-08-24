import { Component, OnInit } from '@angular/core';

import { VehicleOwnerDto } from '../../gen/model/vehicleOwnerDto';
import { VehicleOwnerService } from '../../gen/api/vehicleOwner.service';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';

@Component({
	selector: 'app-vehicle-owner-list',
	templateUrl: './vehicle-owner-view.component.html'
})

export class VehicleOwnerViewComponent implements OnInit {

	title = "Vehicle Owner's List";
	vehicleOwners: VehicleOwnerDto[] = [];
	colspan = 10;
	isActive = false;

	private vehicleService: VehicleOwnerService;
	private router: Router;

	constructor(vehicleService: VehicleOwnerService, router: Router) {
		this.vehicleService = vehicleService;
		this.router = router;
	}

	onSave($event) {
		console.log("Save was clicked", $event);
	}

	getVehicleOwners() {

    console.log("VehicleOwnerViewComponent is called from service");
    return this.vehicleOwners;
    /*
		if (this.vehicleOwners.length == 0) {
			this.vehicleService.findAll().subscribe((vehicleOwners: VehicleOwnerDto[]) => {
				this.vehicleOwners = vehicleOwners;
			})
		}

		return this.vehicleOwners;*/
	}

	getTitle() {
		return this.title;
	}

	onClick($event) {
		// this.getVehicleOwners();
	}

	openDetails() {
    this.router.navigate(['/vehicleOwners/detail']);
	}

	ngOnInit() {
		console.log("VehicleOwnerViewComponent constructor is called");
		this.vehicleService.findAll().subscribe((vehicleOwners: VehicleOwnerDto[]) => {
			this.vehicleOwners = vehicleOwners;
		})
	}
}


