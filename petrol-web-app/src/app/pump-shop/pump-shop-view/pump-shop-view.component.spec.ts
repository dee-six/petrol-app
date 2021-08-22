import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VehicleOwnerViewComponent } from "./vehicle-owner-view.component";
import { VehicleOwnerService } from "../../model/vehicle-owner.service";

describe( 'VehicleOwnerListComponent', () => {
    let component = new VehicleOwnerViewComponent(this._injector.get(VehicleOwnerService));
    let fixture: ComponentFixture<VehicleOwnerViewComponent>;

    beforeEach( async(() => {
        TestBed.configureTestingModule( {
            declarations: [VehicleOwnerViewComponent]
        } )
            .compileComponents();
    } ) );

    beforeEach(() => {
        fixture = TestBed.createComponent( VehicleOwnerViewComponent );
        component = fixture.componentInstance;
        fixture.detectChanges();
    } );

    it( 'should create', () => {
        expect( component ).toBeTruthy();
    } );
} );
