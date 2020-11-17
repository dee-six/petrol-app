import { TestBed } from '@angular/core/testing';

import { VehicleOwnerService } from './vehicle-owner.service';

describe('VehilceOwnerService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: VehicleOwnerService = TestBed.get(VehicleOwnerService);
    expect(service).toBeTruthy();
  });
});
