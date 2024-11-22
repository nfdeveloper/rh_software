import { Injectable } from '@angular/core';
import { environment } from '../../../environments/environment';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class GrupoService {

  private readonly grupoEndPoint: String = `${environment.apiBaseUrl}/grupos`;

  constructor(private http: HttpClient) { }
}
