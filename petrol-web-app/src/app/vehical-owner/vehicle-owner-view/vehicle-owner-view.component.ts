import { Component, OnInit } from '@angular/core';
import { VehicleOwner} from '../../model/vehicle-owner';
import { VehicleOwnerService } from '../../model/vehicle-owner.service';

@Component( {
    selector:    'app-vehicle-owner-list',
    templateUrl: './vehicle-owner-view.component.html'
} )


export class VehicleOwnerViewComponent implements OnInit {

    title = "Vehical Owner's List";
    vehicleOwners: VehicleOwner[];
    colspan=10;
    isActive=false;

    constructor(private vehicleService: VehicleOwnerService) {
        this.vehicleOwners = this.vehicleService.getVehicleOwner();
    }

    onSave($event) {
      console.log("Save was clicked", $event);
    }

    getTitle() {
       return  this.title;
    }

    ngOnInit() {
    }

}
