import { Component, OnInit } from '@angular/core';
import { DialogService, DynamicDialogRef } from 'primeng/dynamicdialog';
import { Setor } from '../../core/models/setor/setor.model';
import { SetorService } from '../../core/services/setor.service';
import { ConfirmationService, MessageService } from 'primeng/api';
import { ModalCriarEditarSetorComponent } from './modal-criar-editar-setor/modal-criar-editar-setor.component';
import { TooltipModule } from 'primeng/tooltip';
import { TagModule } from 'primeng/tag';
import { ButtonModule } from 'primeng/button';
import { TableModule } from 'primeng/table';
import { ToastModule } from 'primeng/toast';
import { ConfirmDialogModule } from 'primeng/confirmdialog';

@Component({
  selector: 'app-setores',
  standalone: true,
  imports: [
    ConfirmDialogModule,
    ToastModule,
    TableModule,
    ButtonModule,
    TagModule,
    TooltipModule
  ],
  templateUrl: './setores.component.html',
  styleUrl: './setores.component.scss'
})
export class SetoresComponent implements OnInit{

  setores: Setor[] = [];
  ref: DynamicDialogRef | undefined;
  
  constructor(
    private service: SetorService,
    private messageService: MessageService,
    private dialogService: DialogService,
    private confirmationService: ConfirmationService
  ){ }

  ngOnInit(): void {
    this.recuperaSetores();
  }

  recuperaSetores() {
    this.service.listar().subscribe(
      res => {
        this.setores = res;
      }
    )
  }

  show(setor?: Setor){
      var editar = setor ? true : false;
          this.ref = this.dialogService.open(
            ModalCriarEditarSetorComponent,
            {
              header: editar ? 'Editar Setor' : 'Criar Setor',
              width: '40rem',
              height: '25rem',
              modal: true,
              data: {
                setor: setor,
              }
      
            }
          )
      
          this.ref.onClose.subscribe((data: any) => {
            if(data.setor && !editar){
              this.criar(data.setor);
            }
          })
    }
  
    criar(setor: Setor){
        this.service.criar(setor).subscribe(
          result => {
            this.messageService.add({
              severity: 'success',
              summary: 'Sucesso',
              detail: 'Função criada com sucesso!',
            });
            this.recuperaSetores();
          }
        )
    }
  
    confirmarDesativacao(setor: Setor) {
        this.confirmationService.confirm({
          message: 'Deseja desativar Setor?',
          header: 'Desativar Setor',
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
