import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModalCriarEditarFuncaoComponent } from './modal-criar-editar-funcao.component';

describe('ModalCriarEditarFuncaoComponent', () => {
  let component: ModalCriarEditarFuncaoComponent;
  let fixture: ComponentFixture<ModalCriarEditarFuncaoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ModalCriarEditarFuncaoComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ModalCriarEditarFuncaoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
