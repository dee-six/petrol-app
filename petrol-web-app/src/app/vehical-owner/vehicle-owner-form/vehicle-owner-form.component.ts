import {Component, OnInit} from '@angular/core';

import {VehicleOwner} from '../../model/vehicle-owner';
import {VehicleOwnerService} from '../../model/vehicle-owner.service';

@Component({
  selector: 'vehicle-owner-form',
  templateUrl: './vehicle-owner-form.component.html'
})

export class VehicleOwnerFormComponent implements OnInit {

  private vehicleService: VehicleOwnerService;

  constructor(vehicleService: VehicleOwnerService) {
    this.vehicleService = vehicleService;
  }

  ngOnInit() {
  }

  log(value) {
    console.log(value);
  }

  save(form) {
    console.log(form);
    this.vehicleService.save(form.value);
  }
}
