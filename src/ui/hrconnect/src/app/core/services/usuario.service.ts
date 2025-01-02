import { Injectable } from '@angular/core';
import { environment } from '../../../environments/environment';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  private readonly usuarioEndPoint: String = `${environment.apiBaseUrl}/usuarios`;

  constructor(private http: HttpClient) { }
}
