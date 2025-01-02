import { Injectable } from '@angular/core';
import { environment } from '../../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Funcao } from '../models/funcao/funcao.model';
import { FuncaoCreate } from '../models/funcao/funcao-create.model';

@Injectable({
  providedIn: 'root'
})
export class FuncaoService {

  private readonly funcaoEndPoint: String = `${environment.apiBaseUrl}/funcoes`;

  constructor(private http: HttpClient) { }

  listar(): Observable<Funcao[]> {
    return this.http.get<Funcao[]>(`${this.funcaoEndPoint}`);
  }

  criar(funcao: FuncaoCreate): Observable<Funcao> {
    return this.http.post(`${this.funcaoEndPoint}`, funcao);
  }

  listarAtivos(): Observable<Funcao[]> {
      return this.http.get<Funcao[]>(`${this.funcaoEndPoint}/ativos`);
    }
}
