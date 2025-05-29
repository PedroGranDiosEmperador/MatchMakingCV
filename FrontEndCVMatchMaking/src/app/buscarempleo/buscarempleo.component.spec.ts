import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BuscarempleoComponent } from './buscarempleo.component';

describe('BuscarempleoComponent', () => {
  let component: BuscarempleoComponent;
  let fixture: ComponentFixture<BuscarempleoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [BuscarempleoComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BuscarempleoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
