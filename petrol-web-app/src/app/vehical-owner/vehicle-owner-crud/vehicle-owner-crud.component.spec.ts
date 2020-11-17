import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VehicleOwner.CrudComponent } from './vehicle-owner.crud.component';

describe('VehicleOwner.CrudComponent', () => {
  let component: VehicleOwner.CrudComponent;
  let fixture: ComponentFixture<VehicleOwner.CrudComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VehicleOwner.CrudComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(VehicleOwner.CrudComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
