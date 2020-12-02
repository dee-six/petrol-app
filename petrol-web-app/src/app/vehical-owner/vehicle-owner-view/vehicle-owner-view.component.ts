import {Component, OnInit} from '@angular/core';
import {VehicleOwner} from '../../model/vehicle-owner';
import {VehicleOwnerService} from '../../model/vehicle-owner.service';

@Component({
  selector: 'app-vehicle-owner-list',
  templateUrl: './vehicle-owner-view.component.html'
})

export class VehicleOwnerViewComponent implements OnInit {

  title = "Vehicle Owner's List";
  vehicleOwners: VehicleOwner[];
  colspan = 10;
  isActive = false;

  constructor(private vehicleService: VehicleOwnerService) {
    
  }

  onSave($event) {
    console.log("Save was clicked", $event);
  }

  getVehicleOwners() {
    if (this.vehicleOwners.length == 0) {
      this.vehicleOwners = this.vehicleService.getAllVehicleOwners();
    }
    return this.vehicleOwners;
  }

  getTitle() {
    return this.title;
  }

  onClick($event) {
    this.vehicleOwners = this.vehicleService.getAllVehicleOwners();
  }

  ngOnInit() {
    console.log("VehicleOwnerViewComponent constructor is called")
    this.vehicleOwners = this.vehicleService.getAllVehicleOwners();
  }

}
