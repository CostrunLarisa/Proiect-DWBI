import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShopsproductsComponent } from './shopsproducts.component';

describe('ShopsproductsComponent', () => {
  let component: ShopsproductsComponent;
  let fixture: ComponentFixture<ShopsproductsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ShopsproductsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ShopsproductsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
