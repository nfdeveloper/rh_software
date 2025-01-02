import { Component, OnInit } from '@angular/core';
import { FuncionarioCreate } from '../../../core/models/funcionario/funcionario.create.model';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { FuncionarioService } from '../../../core/services/funcionario.service';
import { MessageService } from 'primeng/api';
import { SetorService } from '../../../core/services/setor.service';
import { FuncaoService } from '../../../core/services/funcao.service';
import { Setor } from '../../../core/models/setor/setor.model';
import { Funcao } from '../../../core/models/funcao/funcao.model';
import { CommonModule } from '@angular/common';
import { InputTextModule } from 'primeng/inputtext';
import { ButtonModule } from 'primeng/button';
import { InputMaskModule } from 'primeng/inputmask';
import { DropdownModule } from 'primeng/dropdown';



@Component({
  selector: 'app-criar-funcionario',
  standalone: true,
  imports: [
    CommonModule,
    ReactiveFormsModule,
    InputTextModule,
    ButtonModule,
    InputMaskModule,
    DropdownModule
  ],
  templateUrl: './criar-funcionario.component.html',
  styleUrl: './criar-funcionario.component.scss'
})
export class CriarFuncionarioComponent implements OnInit{
  
  funcionarioCreate: FuncionarioCreate = new FuncionarioCreate();
  funcionarioForms: any = FormGroup;
  setores: Setor[] = [];
  funcoes: Funcao[] = [];
  sexosNascimento = [{'valor':"Masculino"}, {'valor':"Feminino"}]

  constructor(
    private formBuilder: FormBuilder,
    private service: FuncionarioService,
    private messageService: MessageService,
    private setorService: SetorService,
    private funcaoService: FuncaoService
  ){ }
  
  ngOnInit(): void {
    this.recuperaSetores();
    this.recuperaFuncoes();

    this.funcionarioForms = this.formBuilder.group({
      nomeCompleto: [null, [Validators.required]],
      sobrenome: [null, [Validators.required]],
      cpf: [null, [Validators.required]],
      dataNascimento: [null, [Validators.required]],
      dataAdmissao: [null, [Validators.required]],
      sexoNascimento: [null, [Validators.required]],
      peso: [null, [Validators.required]],
      altura: [null, [Validators.required]],
      pcd: [null, [Validators.required]],
      possuiFilhos: [false],
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
      setorId: [null, [Validators.required]],
      funcaoId: [null, [Validators.required]]
    })
  }
  

  recuperaFuncoes(){
    this.funcaoService.listarAtivos().subscribe(
      res => {
        this.funcoes = res;
      }
    )
  }

  recuperaSetores(){
    this.setorService.listarAtivos().subscribe(
      res => {
        this.setores = res;
      }
    )
  }

  salvar() {
    
  }
}
