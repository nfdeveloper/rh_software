import { Component, OnInit } from '@angular/core';
import { ButtonModule } from 'primeng/button';
import { ConfirmDialogModule } from 'primeng/confirmdialog';
import { TableModule } from 'primeng/table';
import { TagModule } from 'primeng/tag';
import { ToastModule } from 'primeng/toast';
import { TooltipModule } from 'primeng/tooltip';
import { Funcao } from '../../core/models/funcao/funcao.model';
import { DialogService, DynamicDialogRef } from 'primeng/dynamicdialog';
import { FuncaoService } from '../../core/services/funcao.service';
import { ConfirmationService, MessageService } from 'primeng/api';
import { ModalCriarEditarFuncaoComponent } from './modal-criar-editar-funcao/modal-criar-editar-funcao.component';
import { FuncaoCreate } from '../../core/models/funcao/funcao-create.model';

@Component({
  selector: 'app-funcoes',
  standalone: true,
  imports: [
    ConfirmDialogModule,
    ToastModule,
    TableModule,
    ButtonModule,
    TagModule,
    TooltipModule
  ],
  templateUrl: './funcoes.component.html',
  styleUrl: './funcoes.component.scss'
})
export class FuncoesComponent implements OnInit{

  funcoes: Funcao[] = [];
  ref: DynamicDialogRef | undefined;

  constructor(
    private service: FuncaoService,
    private messageService: MessageService,
    private dialogService: DialogService,
    private confirmationService: ConfirmationService
  ){ }

  ngOnInit(): void {
    this.recuperarFuncoes();
  }

  recuperarFuncoes(){
    this.service.listar().subscribe(
      res => {
        this.funcoes = res;
      }
    )
  }

  show(funcao?: Funcao){
    var editar = funcao ? true : false;
        this.ref = this.dialogService.open(
          ModalCriarEditarFuncaoComponent,
          {
            header: editar ? 'Editar Função' : 'Criar Função',
            width: '40rem',
            height: '25rem',
            modal: true,
            data: {
              funcao: funcao,
            }
    
          }
        )
    
        this.ref.onClose.subscribe((data: any) => {
          if(data.grupo && !editar){
            this.criar(data.funcao);
          }
        })
  }

  criar(funcao: FuncaoCreate){
      this.service.criar(funcao).subscribe(
        result => {
          this.messageService.add({
            severity: 'success',
            summary: 'Sucesso',
            detail: 'Função criada com sucesso!',
          });
          this.recuperarFuncoes();
        }
      )
  }

  confirmarDesativacao(funcao: Funcao) {
      this.confirmationService.confirm({
        message: 'Deseja desativar Função?',
        header: 'Desativar Função',
        icon: 'pi pi-question-circle',
        rejectButtonStyleClass: 'w-2 p-button-danger',
        acceptButtonStyleClass: 'w-2',
        acceptIcon: 'pi pi-check',
        rejectIcon: 'pi pi-times',
        acceptLabel: 'Sim',
        rejectLabel: 'Não',
        //accept:     
        reject: () => this.confirmationService.close()
      }) 
  }
}
