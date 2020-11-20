import { ComponentFixture, TestBed } from '@angular/core/testing';

import {VehicleOwnerCrudComponent} from "./vehicle-owner-crud.component";

describe('VehicleOwner.CrudComponent', () => {
  let component: VehicleOwnerCrudComponent;
  let fixture: ComponentFixture<VehicleOwnerCrudComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VehicleOwnerCrudComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(VehicleOwnerCrudComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
