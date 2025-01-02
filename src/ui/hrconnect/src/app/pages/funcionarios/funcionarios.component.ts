import { Component, OnInit } from '@angular/core';
import { Funcionario } from '../../core/models/funcionario/funcionario.model';
import { FuncionarioService } from '../../core/services/funcionario.service';
import { ConfirmationService, MessageService } from 'primeng/api';
import { DialogService, DynamicDialogRef } from 'primeng/dynamicdialog';
import { ConfirmDialogModule } from 'primeng/confirmdialog';
import { ToastModule } from 'primeng/toast';
import { TableModule } from 'primeng/table';
import { ButtonModule } from 'primeng/button';
import { TagModule } from 'primeng/tag';
import { TooltipModule } from 'primeng/tooltip';
import { Router } from '@angular/router';

@Component({
  selector: 'app-funcionarios',
  standalone: true,
  imports: [
    ConfirmDialogModule,
    ToastModule,
    TableModule,
    ButtonModule,
    TagModule,
    TooltipModule
  ],
  templateUrl: './funcionarios.component.html',
  styleUrl: './funcionarios.component.scss'
})
export class FuncionariosComponent implements OnInit{

  funcionarios: Funcionario[] = [];
  ref: DynamicDialogRef | undefined;
  
    constructor(
      private service: FuncionarioService,
      private messageService: MessageService,
      private dialogService: DialogService,
      private confirmationService: ConfirmationService,
      private router: Router
    ){ }

  ngOnInit(): void {
    this.recuperarFuncionarios();
  }

  recuperarFuncionarios(){
    this.service.listar().subscribe(
      res => {
        this.funcionarios = res;
      }
    )
  }

  criarFuncionario(){
    this.router.navigate(["/funcionarios-criar"])
  }

  editar(funcionario: Funcionario){

  }

  confirmarDesativacao(funcionario: Funcionario) {
        this.confirmationService.confirm({
          message: 'Deseja desativar Funcionário?',
          header: 'Desativar Funcionário',
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
