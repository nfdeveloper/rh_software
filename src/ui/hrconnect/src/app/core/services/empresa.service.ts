import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../../environments/environment';
import { Observable } from 'rxjs';
import { Empresa } from '../models/empresa/empresa.model';
import { EmpresaCreate } from '../models/empresa/empresa-create.model';

@Injectable({
  providedIn: 'root'
})
export class EmpresaService {
  private readonly empresaEndPoint: String = `${environment.apiBaseUrl}/empresas`;

  constructor(private http: HttpClient) { }

  listar(): Observable<Empresa[]> {
    return this.http.get<Empresa[]>(`${this.empresaEndPoint}`);
  }

  criar(empresa: EmpresaCreate): Observable<Empresa> {
    return this.http.post(`${this.empresaEndPoint}`, empresa);
  }
}
