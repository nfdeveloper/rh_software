import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { ButtonModule } from 'primeng/button';
import { InputTextModule } from 'primeng/inputtext';
import { InputMaskModule } from 'primeng/inputmask';
import { DynamicDialogConfig, DynamicDialogRef } from 'primeng/dynamicdialog';
import { Grupo } from '../../../core/models/grupo/grupo.model';

@Component({
  selector: 'app-modal-criar-editar-grupo',
  standalone: true,
  imports: [
    CommonModule,
    ReactiveFormsModule,
    InputTextModule,
    ButtonModule,
    InputMaskModule
  ],
  templateUrl: './modal-criar-editar-grupo.component.html',
  styleUrl: './modal-criar-editar-grupo.component.scss'
})
export class ModalCriarEditarGrupoComponent implements OnInit{

  grupoForms: any = FormGroup;
  grupo: Grupo = new Grupo();


  constructor(
    private ref: DynamicDialogRef,
    public config: DynamicDialogConfig,
    private formBuilder: FormBuilder
  ){  }

  ngOnInit(): void {
    if(this.config.data.grupo){
      this.grupo = this.config.data.grupo;
    }

    this.grupoForms = this.formBuilder.group({
      id: [this.grupo.id],
      nome: [this.grupo.nome, [Validators.required]],
      telefone: [this.grupo.telefone],
      celular: [this.grupo.celular, [Validators.required]],
      email: [this.grupo.email, [Validators.required]]
    })
  }

  salvar(){
    this.grupo = this.grupoForms.value;

    this.ref.close({ grupo: this.grupo });
  }

  fecharModal(){
    this.ref.close();
  }

}
