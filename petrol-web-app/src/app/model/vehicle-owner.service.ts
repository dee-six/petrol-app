import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {VehicleOwner} from "./vehicle-owner";

var vehicleOwners = [
  {
    id: 1,
    name: "Deepak",
    address1: "Alfred ",
    address2: "Comte",
    pinCode: "8953",
    country: "Switzerland",
    subscriptionPaid: "yes"
  },
  {
    id: 2,
    name: "Diya",
    address1: "Alfred ",
    address2: "Comte",
    pinCode: "8953",
    country: "Switzerland",
    subscriptionPaid: "no"
  }
];

@Injectable({
  providedIn: 'root'
})

export class VehicleOwnerService {

  private vehicleOwners: VehicleOwner[];
  private http;


  constructor(private httpclient: HttpClient) {
    this.http = httpclient;
  }

  getAllVehicleOwners() {
    this.http.get("/petrol/vehicleowner").subscribe(response => {
      this.vehicleOwners = response;
      console.log(this.vehicleOwners);
    });

    return this.vehicleOwners

  }

  save(vehicleOwner) {
    this.vehicleOwners.push(vehicleOwner)
    console.log(this.vehicleOwners);
  }
}
