import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { MessageService } from 'primeng/api';
import { ButtonModule } from 'primeng/button';
import { InputMaskModule } from 'primeng/inputmask';
import { InputTextModule } from 'primeng/inputtext';
import { EmpresaCreate } from '../../../core/models/empresa/empresa-create.model';
import { EmpresaService } from '../../../core/services/empresa.service';

@Component({
  selector: 'app-criar-empresa',
  standalone: true,
  imports: [
    CommonModule,
    ReactiveFormsModule,
    InputTextModule,
    ButtonModule,
    InputMaskModule
  ],
  templateUrl: './criar-empresa.component.html',
  styleUrl: './criar-empresa.component.scss'
})
export class CriarEmpresaComponent implements OnInit{

  empresaCreate: EmpresaCreate = new EmpresaCreate();
  empresaForms: any = FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private service: EmpresaService,
    private messageService: MessageService
  ){ }

  ngOnInit(): void {
    this.empresaForms = this.formBuilder.group({
      razaoSocial: [null, [Validators.required]],
      fantasia: [null, [Validators.required]],
      cnpj: [null, [Validators.required]],
      quantidadeFuncionarios: [null, [Validators.required]],
      cep: [null, [Validators.required]],
      estado: [null, [Validators.required]],
      cidade: [null, [Validators.required]],
      bairro: [null, [Validators.required]],
      rua: [null, [Validators.required]],
      numero: [null, [Validators.required]],
      pontoReferencia: [null],
      complemento: [null],
      telefone1: [null, [Validators.required]],
      telefone2: [null],
      telefone3: [null],
      telefone4: [null],
      celular1: [null, [Validators.required]],
      celular2: [null],
      celular3: [null],
      celular4: [null],
      email1: [null, [Validators.required]],
      email2: [null],
      email3: [null],
      email4: [null],      
    })
  }

  salvar(){
    this.empresaCreate.razaoSocial = this.empresaForms.value.razaoSocial;
    this.empresaCreate.fantasia = this.empresaForms.value.fantasia;
    this.empresaCreate.cnpj = this.normalizacnpj(this.empresaForms.value.cnpj);
    this.empresaCreate.quantidadeFuncionarios = this.empresaForms.value.quantidadeFuncionarios;
    this.empresaCreate.contato!.celular1 = this.normalizaTelefone(this.empresaForms.value.celular1);
    if(this.empresaForms.value.celular2){
      this.empresaCreate.contato!.celular2 = this.normalizaTelefone(this.empresaForms.value.celular2);
    }
    if(this.empresaForms.value.celular3){
      this.empresaCreate.contato!.celular3 = this.normalizaTelefone(this.empresaForms.value.celular3);
    }
    if(this.empresaForms.value.celular4){
      this.empresaCreate.contato!.celular4 = this.normalizaTelefone(this.empresaForms.value.celular4);
    }

    this.empresaCreate.contato!.telefone1 = this.normalizaTelefone(this.empresaForms.value.telefone1);
    if(this.empresaForms.value.telefone2){
      this.empresaCreate.contato!.telefone2 = this.normalizaTelefone(this.empresaForms.value.telefone2);
    }
    if(this.empresaForms.value.telefone3){
      this.empresaCreate.contato!.telefone3 = this.normalizaTelefone(this.empresaForms.value.telefone3);
    }
    if(this.empresaForms.value.telefone4){
      this.empresaCreate.contato!.telefone4 = this.normalizaTelefone(this.empresaForms.value.telefone4);
    };
    this.empresaCreate.contato!.email1 = this.empresaForms.value.email1;
    
    if(this.empresaForms.value.email2){
      this.empresaCreate.contato!.email2 = this.empresaForms.value.email2;
    }
    if(this.empresaForms.value.email3){
      this.empresaCreate.contato!.email3 = this.empresaForms.value.email3;
    }
    if(this.empresaForms.value.email4){
      this.empresaCreate.contato!.email4 = this.empresaForms.value.email4;
    }
    this.empresaCreate.endereco!.cep = this.normalizacep(this.empresaForms.value.cep);
    this.empresaCreate.endereco!.estado = this.empresaForms.value.estado;
    this.empresaCreate.endereco!.cidade = this.empresaForms.value.cidade;
    this.empresaCreate.endereco!.bairro = this.empresaForms.value.bairro;
    this.empresaCreate.endereco!.rua = this.empresaForms.value.rua;
    this.empresaCreate.endereco!.numero = this.empresaForms.value.numero;
    this.empresaCreate.endereco!.pontoReferencia = this.empresaForms.value.pontoReferencia;
    this.empresaCreate.endereco!.complemento = this.empresaForms.complemento;

    this.service.criar(this.empresaCreate).subscribe(
      result => {
        this.messageService.add({
          severity: 'success',
          summary: 'Sucesso',
          detail: 'Empresa criada com sucesso!',
        });

        this.empresaForms.clear();
      }
    )

  }

  normalizaTelefone(telefone: string){
    return telefone.replace('(','').replace(')','').replace(' ','').replace('-','');  
  }

  normalizacep(cep: string){
    return cep.replace('-','');
  }

  normalizacnpj(cnpj: string){
    return cnpj.replace('.','').replace('.','').replace('/', '').replace('-', '');
  }
}
