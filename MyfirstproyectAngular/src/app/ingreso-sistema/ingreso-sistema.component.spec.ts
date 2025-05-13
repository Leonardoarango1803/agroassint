import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IngresoSistemaComponent } from './ingreso-sistema.component';

describe('IngresoSistemaComponent', () => {
  let component: IngresoSistemaComponent;
  let fixture: ComponentFixture<IngresoSistemaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [IngresoSistemaComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(IngresoSistemaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
