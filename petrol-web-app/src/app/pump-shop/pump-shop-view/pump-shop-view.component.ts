import { Component, OnInit } from '@angular/core';

import { PumpShopDto } from '../../gen/model/pumpShopDto';
import { PumpShopsService } from '../../gen/api/pumpShops.service';
import { Observable } from 'rxjs';


@Component({
	selector: 'pumps-shop-list',
	templateUrl: './pump-shop-view.component.html'
})

export class PumpShopViewComponent implements OnInit {

	title = "Pump Shops";
	pumpShops: PumpShopDto[] = [];
	colspan = 10;

	constructor(private pumpShopService: PumpShopsService) {
	}

	getPumpShops() {
    console.log("PumpShopViewComponent is called from service");
    return this.pumpShops;
	}

	getTitle() {
		return this.title;
	}

	onClick($event) {
		console.log($event);
	}

  openDetails() {
    console.log("Doubel clicked !");
  }

	ngOnInit() {
		console.log("PumpShopViewComponent constructor is called");
		this.pumpShopService.getPumpshops().subscribe((pumpShops: PumpShopDto[]) => {
			this.pumpShops = pumpShops;
		})
	}
}


