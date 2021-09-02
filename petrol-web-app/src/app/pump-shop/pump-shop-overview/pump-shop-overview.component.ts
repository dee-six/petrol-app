import { Component, OnInit } from '@angular/core';

import { PumpShopDto } from '../../gen/model/pumpShopDto';
import { PumpShopsService } from '../../gen/api/pumpShops.service';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';

@Component({
	selector: 'pumps-shop-list',
	templateUrl: './pump-shop-overview.component.html'
})

export class PumpShopOverviewComponent implements OnInit {

	title = "Pump Shops";
	pumpShops: PumpShopDto[] = [];
	colspan = 10;

	constructor(private pumpShopService: PumpShopsService, private router: Router) {

	}

	getPumpShops() {
    console.log("PumpShopOverviewComponent is called from service");
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
    this.router.navigate(['/pumpShops/detail']);
  }

	ngOnInit() {
		console.log("PumpShopViewComponent constructor is called");
		this.pumpShopService.getPumpshops().subscribe((pumpShops: PumpShopDto[]) => {
			this.pumpShops = pumpShops;
		})
	}
}


