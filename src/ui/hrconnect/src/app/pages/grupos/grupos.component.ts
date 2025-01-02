import { Component, OnInit } from '@angular/core';
import { ButtonModule } from 'primeng/button';
import { TooltipModule } from 'primeng/tooltip';
import { TableModule } from 'primeng/table';
import { TagModule } from 'primeng/tag';
import { ToastModule } from 'primeng/toast';
import { ConfirmDialogModule } from 'primeng/confirmdialog';
import { Grupo } from '../../core/models/grupo/grupo.model';
import { DialogService, DynamicDialogRef } from 'primeng/dynamicdialog';
import { ConfirmationService, MessageService } from 'primeng/api';
import { GrupoService } from '../../core/services/grupo.service';
import { ModalCriarEditarGrupoComponent } from './modal-criar-editar-grupo/modal-criar-editar-grupo.component';

@Component({
  selector: 'app-grupos',
  standalone: true,
  imports: [
    ConfirmDialogModule,
    ToastModule,
    TableModule,
    ButtonModule,
    TagModule,
    TooltipModule
  ],
  templateUrl: './grupos.component.html',
  styleUrl: './grupos.component.scss'
})
export class GruposComponent implements OnInit{
  
  grupos: Grupo[] = [];
  ref: DynamicDialogRef | undefined;

  constructor(
    private service: GrupoService,
    private messageService: MessageService,
    private dialogService: DialogService,
    private confirmationService: ConfirmationService
  ) { }
  
  ngOnInit(): void {
    this.recuperarGrupos();

  }

  recuperarGrupos(){
    this.service.listar().subscribe(
      result => {
        this.grupos = result;
      }
    )
  }

  show(grupo?: Grupo){
    var editar = grupo ? true : false;
    this.ref = this.dialogService.open(
      ModalCriarEditarGrupoComponent,
      {
        header: editar ? 'Editar Grupo' : 'Criar Grupo',
        width: '40rem',
        height: '25rem',
        modal: true,
        data: {
          grupo: grupo,
        }

      }
    )

    this.ref.onClose.subscribe((data: any) => {
      if(data.grupo && !editar){
        this.criar(data.grupo);
      }
    })
  }



  criar(grupo: Grupo){
    this.service.criar(grupo).subscribe(
      result => {
        this.messageService.add({
          severity: 'success',
          summary: 'Sucesso',
          detail: 'Grupo criado com sucesso!',
        });
        this.recuperarGrupos();
      }
    )
  }


  confirmarDesativacao(grupo: Grupo) {
    this.confirmationService.confirm({
      message: 'Deseja desativar Grupo?',
      header: 'Desativar Grupo',
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
