import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {VehicleOwner} from "./vehicle-owner";
import { map } from 'rxjs/operators';

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

  private vehicleOwners: VehicleOwner[] = [];
  private http;


  constructor(private httpclient: HttpClient) {
    this.http = httpclient;
  }

  getAllVehicleOwners() {
	
    if (this.vehicleOwners.length == 0) {

      this.http.get("api/petrol/vehicleowner")
      .subscribe(
        (response: VehicleOwner[]) => {
          this.vehicleOwners = response;
          console.log("Respose Recieved: ", this.vehicleOwners);
        },
        (error: Response) => {
           if (error.status === 400) {
             alert("Error");
           }
        } 
      );
    }

    return this.vehicleOwners
  }

  save(vehicleOwner) {
    console.log("VehicleOwner to save: ", vehicleOwner);
    this.vehicleOwners.push(vehicleOwner)
    console.log(this.vehicleOwners);
  }
}
