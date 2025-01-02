import { Injectable } from '@angular/core';
import { environment } from '../../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Grupo } from '../models/grupo/grupo.model';

@Injectable({
  providedIn: 'root'
})
export class GrupoService {

  private readonly grupoEndPoint: String = `${environment.apiBaseUrl}/grupos`;

  constructor(private http: HttpClient) { }

  listar(): Observable<Grupo[]>{
    return this.http.get<Grupo[]>(`${this.grupoEndPoint}`)
  }

  criar(grupo: Grupo): Observable<Grupo> {
    return this.http.post(`${this.grupoEndPoint}`, grupo);
  }
  
}
