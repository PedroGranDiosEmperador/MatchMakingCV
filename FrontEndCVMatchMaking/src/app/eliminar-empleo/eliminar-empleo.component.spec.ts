import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EliminarEmpleoComponent } from './eliminar-empleo.component';

describe('EliminarEmpleoComponent', () => {
  let component: EliminarEmpleoComponent;
  let fixture: ComponentFixture<EliminarEmpleoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EliminarEmpleoComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EliminarEmpleoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
