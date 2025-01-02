import { Component, OnInit } from '@angular/core';
import { SidebarModule } from 'primeng/sidebar';
import { ButtonModule } from 'primeng/button';
import { MenuModule } from 'primeng/menu';
import { MenuItem } from 'primeng/api';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { AuthService } from '../../core/services/auth.service';

@Component({
  selector: 'app-navegacao',
  standalone: true,
  imports: [
    CommonModule,
    SidebarModule,
    ButtonModule,
    MenuModule
  ],
  templateUrl: './navegacao.component.html',
  styleUrl: './navegacao.component.scss'
})
export class NavegacaoComponent implements OnInit{

  sidebarVisible: boolean = false;
  items: MenuItem[] | undefined;

  constructor(private router: Router, private authService: AuthService){ };
  
  ngOnInit(): void {
    this.items = [
      {
          label: 'Administração',
          items: [
              {
                  label: 'Início',
                  icon: 'pi pi-warehouse',
                  command: () => {
                    this.router.navigate(["/home"])
                    this.sidebarVisible = false;
                  }
              },
              {
                label: 'Funcionários',
                icon: 'pi pi-address-book',
                command: () => {
                  this.router.navigate(["/funcionarios"])
                  this.sidebarVisible = false;
                }
            },
              {
                  label: 'Funções',
                  icon: 'pi pi-list-check',
                  command: () => {
                    this.router.navigate(["/funcoes"])
                    this.sidebarVisible = false;
                  }
              },
              {
                  label: 'Setores',
                  icon: 'pi pi-clipboard',
                  command: () => {
                    this.router.navigate(["/setores"])
                    this.sidebarVisible = false;
                  }
              },
              {
                label: 'Empresas',
                icon: 'pi pi-building',
                command: () => {
                  this.router.navigate(["/empresas"])
                  this.sidebarVisible = false;
                }
              },
              {
                label: 'Grupos',
                icon: 'pi pi-building',
                command: () => {
                  this.router.navigate(["/grupos"])
                  this.sidebarVisible = false;
                }
              },
              {
                label: 'Ponto Web',
                icon: 'pi pi-book',
                command: () => {
                  this.router.navigate(["/marcacoes"])
                  this.sidebarVisible = false;
                }
              },
              {
                label: 'Usuários',
                icon: 'pi pi-user',
                command: () => {
                  this.router.navigate(["/usuarios"])
                  this.sidebarVisible = false;
                }
              }
          ]
      },
      {
          label: 'Meu Ponto',
          items: [
              {
                  label: 'Registrar Ponto',
                  icon: 'pi pi-chart-line',
                  command: () => {
                    this.router.navigate(["/"])
                    this.sidebarVisible = false;
                  }
              },
              {
                label: 'Folha de Ponto',
                icon: 'pi pi-chart-line',
                command: () => {
                  this.router.navigate(["/"])
                  this.sidebarVisible = false;
                }
              },
              {
                label: 'Novas Solicitação',
                icon: 'pi pi-chart-line',
                command: () => {
                  this.router.navigate(["/"])
                  this.sidebarVisible = false;
                }
              },
              {
                label: 'Minhas Solicitações',
                icon: 'pi pi-chart-line',
                command: () => {
                  this.router.navigate(["/"])
                  this.sidebarVisible = false;
                }
              },
          ]
      }
  ];
  }

}
