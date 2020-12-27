import { Component, OnInit } from '@angular/core';

import { VehicleOwnerDto } from '../../gen/model/vehicleOwnerDto';
import { VehicleOwnerService } from '../../gen/api/vehicleOwner.service';

import { Router } from '@angular/router';

@Component({
	selector: 'vehicle-owner-form',
	templateUrl: './vehicle-owner-form.component.html'
})

export class VehicleOwnerFormComponent implements OnInit {

	private vehicleService: VehicleOwnerService;
	private router: Router;

	constructor(vehicleService: VehicleOwnerService, router: Router) {
		this.vehicleService = vehicleService;
		this.router = router;
	}

	ngOnInit() {
	}

	log(value) {
		console.log(value);
	}

	save(form) {
		console.log(form);
		let vehicleOwner: VehicleOwnerDto = {};
		vehicleOwner.address1 = form.value.owner.address1;
		vehicleOwner.address2 = form.value.owner.address2;
		vehicleOwner.city = form.value.owner.city;
		vehicleOwner.name = form.value.owner.name1;

		this.vehicleService.addVehicleOwner(vehicleOwner).subscribe((vehicleOwner: VehicleOwnerDto) => {
			console.log("Data SaVE: " + vehicleOwner);
			
		})
		
		this.router.navigate(['/vehicleOwners']);
	}
}

