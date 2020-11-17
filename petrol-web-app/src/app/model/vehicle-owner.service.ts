import { Injectable } from '@angular/core';

var vehicleOwners = [
	{ id: 1, name: "Deepak", address1: "Alfred ", address2: "Comte", pinCode:"8953", country: "Switzerland", subscriptionPaid: "yes"}, 
	{ id: 2, name: "Diya", address1: "Alfred ", address2: "Comte", pinCode:"8953", country: "Switzerland", subscriptionPaid: "no"}
	];

@Injectable( {
    providedIn: 'root'
} )

export class VehicleOwnerService {

    private vehicleOwners;
    
    constructor() { 
        this.vehicleOwners = vehicleOwners;
    }
    
    getVehicleOwner() {
        return this.vehicleOwners;
    }

	save(vehicleOwner) {
		vehicleOwners.push(vehicleOwner);
	}
}
