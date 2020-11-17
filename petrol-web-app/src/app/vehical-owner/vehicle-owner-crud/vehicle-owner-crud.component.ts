import { Component, OnInit, Injectable } from '@angular/core';
import {  } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'vehicle-owner-crud',
  templateUrl: './vehicle-owner-crud.component.html',
  styleUrls: ['./vehicle-owner-crud.component.css']
})
export class VehicleOwnerCrudComponent implements OnInit {

  constructor(http: HttpClient) { 

	  http.get('https://jsonplaceholder.typicode.com/posts/1').subscribe(response => {
		  console.log(response);
	  });
	  
  }

  ngOnInit(): void {
  }

}
