import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PumpShopDetailViewComponent } from './pump-shop-detail-view.component';

describe('PumpShopDetailViewComponent', () => {
  let component: PumpShopDetailViewComponent;
  let fixture: ComponentFixture<PumpShopDetailViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PumpShopDetailViewComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PumpShopDetailViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
