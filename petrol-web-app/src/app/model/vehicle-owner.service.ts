import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";

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

  private vehicleOwners;
  private http;

  post: any[];

  constructor(private httpclient: HttpClient) {
    this.http = httpclient;
    this.vehicleOwners = vehicleOwners;
  }

  getVehicleOwner() {
    this.getAllVehicleOwners();
    return this.vehicleOwners;
  }

  getAllVehicleOwners() {
    this.http.get("/petrol/vehicleowner").subscribe(response => {
      this.post = response.json();
      console.log(response.json());
    })
  }
  save(vehicleOwner) {
    vehicleOwners.push(vehicleOwner);
    console.log(this.post);
  }
}
