import { Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { EmpresasComponent } from './pages/empresas/empresas.component';
import { FuncoesComponent } from './pages/funcoes/funcoes.component';
import {SetoresComponent} from './pages/setores/setores.component';
import { GruposComponent } from './pages/grupos/grupos.component';
import { FuncionariosComponent } from './pages/funcionarios/funcionarios.component';
import { MarcacoesComponent } from './pages/marcacoes/marcacoes.component';
import { LoginComponent } from './pages/login/login.component';
import { authGuard } from './http/guards/auth.guard';
import { CriarEmpresaComponent } from './pages/empresas/criar-empresa/criar-empresa.component';
import { CriarFuncionarioComponent } from './pages/funcionarios/criar-funcionario/criar-funcionario.component';

export const routes: Routes = [
    { path: '', component: HomeComponent, canActivate: [authGuard]},
    
    { path: 'empresas', component: EmpresasComponent, canActivate: [authGuard] },
    { path: 'empresas-criar', component: CriarEmpresaComponent, canActivate: [authGuard] },
    
    { path: 'funcoes', component: FuncoesComponent, canActivate: [authGuard] },
    { path: 'setores', component: SetoresComponent, canActivate: [authGuard] },
    { path: 'grupos', component: GruposComponent, canActivate: [authGuard] },
    
    { path: 'funcionarios', component: FuncionariosComponent, canActivate: [authGuard] },
    { path: 'funcionarios-criar', component: CriarFuncionarioComponent, canActivate: [authGuard] },

    { path: 'marcacoes', component: MarcacoesComponent, canActivate: [authGuard] },
    { path: 'login', component: LoginComponent },
];
