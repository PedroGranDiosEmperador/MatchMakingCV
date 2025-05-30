import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SubirEmpleoComponent } from './subir-empleo.component';

describe('SubirEmpleoComponent', () => {
  let component: SubirEmpleoComponent;
  let fixture: ComponentFixture<SubirEmpleoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SubirEmpleoComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SubirEmpleoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
