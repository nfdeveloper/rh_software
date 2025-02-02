import { Injectable } from '@angular/core';
import { environment } from '../../../environments/environment';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class MarcacaoService {

  private readonly marcacaoEndPoint: String = `${environment.apiBaseUrl}/marcacoes`;

  constructor(private http: HttpClient) { }
}
