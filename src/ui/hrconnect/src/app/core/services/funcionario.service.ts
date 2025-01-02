import { Injectable } from '@angular/core';
import { environment } from '../../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Funcionario } from '../models/funcionario/funcionario.model';
import { FuncionarioCreate } from '../models/funcionario/funcionario.create.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FuncionarioService {

  private readonly funcionarioEndPoint: String = `${environment.apiBaseUrl}/funcionarios`;

  constructor(private http: HttpClient) { }

  listar(): Observable<Funcionario[]> {
    return this.http.get<Funcionario[]>(`${this.funcionarioEndPoint}`);
  }

  criar(funcionario: FuncionarioCreate): Observable<Funcionario> {
    return this.http.post(`${this.funcionarioEndPoint}`, funcionario);
  }
}
