import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Validators } from '@angular/forms';

@Component({
	selector: 'app-pump-shop-detail-view',
	templateUrl: './pump-shop-detail-view.component.html',
	styleUrls: ['./pump-shop-detail-view.component.css']
})
export class PumpShopDetailViewComponent implements OnInit {

	pumpShopDetailForm!: FormGroup;

	constructor(private formBuilder: FormBuilder) {
	}

	ngOnInit(): void {

		this.pumpShopDetailForm = this.formBuilder.group({
			header: this.formBuilder.group({
				fullName: ['', [Validators.required, Validators.minLength(10)]],
				description: [''],
			}),
			address: this.formBuilder.group({
				address1: ['', [Validators.required, Validators.minLength(10)]],
				address2: [''],
				city: [''],
				zipCode: [''],
				country: ['']
			})
		});
	}

	onSubmit() {
		console.log(this.pumpShopDetailForm.value);
		console.log(this.pumpShopDetailForm.value.header.name);
		console.log(this.pumpShopDetailForm.value.header.description);
	}

	get fullName() {
		return this.pumpShopDetailForm.get('header.fullName')!;
	}
	get description() { return this.pumpShopDetailForm.get('header.description')!; }
	get address1() { return this.pumpShopDetailForm.get('address.address1')!; }
	get address2() { return this.pumpShopDetailForm.get('address.address2')!; }
	get city() { return this.pumpShopDetailForm.get('address.city')!; }
	get zipCode() { return this.pumpShopDetailForm.get('address.zipCode')!; }
	get country() { return this.pumpShopDetailForm.get('address.country')!; }

}

