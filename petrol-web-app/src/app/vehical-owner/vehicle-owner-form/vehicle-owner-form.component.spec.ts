import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VehicleOwnerFormComponent } from './vehicle-owner-form.component';

describe('VehicleOwnerFormComponent', () => {
  let component: VehicleOwnerFormComponent;
  let fixture: ComponentFixture<VehicleOwnerFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VehicleOwnerFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VehicleOwnerFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
