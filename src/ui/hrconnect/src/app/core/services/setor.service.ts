import { Injectable } from '@angular/core';
import { environment } from '../../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Setor } from '../models/setor/setor.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SetorService {

  private readonly setorEndPoint: String = `${environment.apiBaseUrl}/setores`;

  constructor(private http: HttpClient) { }

  listar(): Observable<Setor[]> {
    return this.http.get<Setor[]>(`${this.setorEndPoint}`);
  }

  criar(setor: Setor): Observable<Setor> {
    return this.http.post(`${this.setorEndPoint}`, setor);
  }

  listarAtivos(): Observable<Setor[]> {
    return this.http.get<Setor[]>(`${this.setorEndPoint}/ativos`);
  }
}
