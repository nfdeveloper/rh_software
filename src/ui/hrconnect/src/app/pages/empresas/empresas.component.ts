import { Component } from '@angular/core';
import { ConfirmationService, MessageService } from 'primeng/api';
import { DialogService, DynamicDialogRef } from 'primeng/dynamicdialog';
import { GrupoService } from '../../core/services/grupo.service';
import { Empresa } from '../../core/models/empresa/empresa.model';
import { TooltipModule } from 'primeng/tooltip';
import { TagModule } from 'primeng/tag';
import { ButtonModule } from 'primeng/button';
import { TableModule } from 'primeng/table';
import { ToastModule } from 'primeng/toast';
import { ConfirmDialogModule } from 'primeng/confirmdialog';
import { EmpresaService } from '../../core/services/empresa.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-empresas',
  standalone: true,
  imports: [
    ConfirmDialogModule,
    ToastModule,
    TableModule,
    ButtonModule,
    TagModule,
    TooltipModule
  ],
  templateUrl: './empresas.component.html',
  styleUrl: './empresas.component.scss'
})
export class EmpresasComponent {

  empresas: Empresa[] = [];
  ref: DynamicDialogRef | undefined;

  constructor(
    private service: EmpresaService,
    private messageService: MessageService,
    private dialogService: DialogService,
    private confirmationService: ConfirmationService,
    private router: Router
  ) { }
  
  ngOnInit(): void {
    this.recuperarEmpresas();

  }

  recuperarEmpresas(){
    this.service.listar().subscribe(
      result => {
        this.empresas = result;
      }
    )
  }

  criarEmpresa(){
    this.router.navigate(["/empresas-criar"])
  }

  editarEmpresa(){
    
  }

  confirmarDesativacao(empresa: Empresa) {
    this.confirmationService.confirm({
      message: 'Deseja desativar Empresa?',
      header: 'Desativar Empresa',
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
