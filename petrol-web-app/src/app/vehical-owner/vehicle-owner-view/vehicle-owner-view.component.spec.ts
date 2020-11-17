import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VehicleOwnerListComponent } from './vehicle-owner-list.component';
import { VehicleOwnerService } from '../model/vehicle-owner.service';

describe( 'VehicleOwnerListComponent', () => {
    let component = new VehicleOwnerListComponent(this._injector.get(VehicleOwnerService));
    let fixture: ComponentFixture<VehicleOwnerListComponent>;

    beforeEach( async(() => {
        TestBed.configureTestingModule( {
            declarations: [VehicleOwnerListComponent]
        } )
            .compileComponents();
    } ) );

    beforeEach(() => {
        fixture = TestBed.createComponent( VehicleOwnerListComponent );
        component = fixture.componentInstance;
        fixture.detectChanges();
    } );

    it( 'should create', () => {
        expect( component ).toBeTruthy();
    } );
} );
