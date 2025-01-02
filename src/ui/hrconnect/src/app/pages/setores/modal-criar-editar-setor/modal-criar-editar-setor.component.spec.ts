import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModalCriarEditarSetorComponent } from './modal-criar-editar-setor.component';

describe('ModalCriarEditarSetorComponent', () => {
  let component: ModalCriarEditarSetorComponent;
  let fixture: ComponentFixture<ModalCriarEditarSetorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ModalCriarEditarSetorComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ModalCriarEditarSetorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
