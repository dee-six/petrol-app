import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Validators } from '@angular/forms';
import { FormArray } from '@angular/forms';
import { FormControl } from '@angular/forms';

@Component({
  selector: 'app-pump-shop-detail-view',
  templateUrl: './pump-shop-detail-view.component.html',
  styleUrls: ['./pump-shop-detail-view.component.css']
})
export class PumpShopDetailViewComponent implements OnInit {

  pumpShopDetailForm = this.formBuilder.group({
        header: this.formBuilder.group({
              name: ['', Validators.required],
              description: [''],
        }),
        address: this.formBuilder.group({
          address1: [''],
          address2: [''],
          city: [''],
          zipCode: [''],
          country: ['']
        })
      });

  constructor(private formBuilder: FormBuilder) {
  }

  ngOnInit(): void {
  }

  onSubmit() {
    console.log(this.pumpShopDetailForm.value);
    console.log(this.pumpShopDetailForm.value.header.name);
    console.log(this.pumpShopDetailForm.value.header.description);
  }
}

