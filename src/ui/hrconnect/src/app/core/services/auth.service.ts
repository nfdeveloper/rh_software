import { Injectable } from '@angular/core';
import { environment } from '../../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { LoginRequest } from '../models/auth/login-request.model';
import { BehaviorSubject, Observable } from 'rxjs';
import { LoginResponse } from '../models/auth/login-response.model';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private readonly authEndPoint: String = `${environment.apiBaseUrl}/auth`;
  private loggedIn = new BehaviorSubject<boolean>(true);

  constructor(private http: HttpClient) { }

  login(login: LoginRequest): Observable<LoginResponse>{
    return this.http.post(`${this.authEndPoint}`, login)
  }

  setDados(usuarioLogado: LoginResponse){
    this.loggedIn.next(true);
    localStorage.setItem("token", usuarioLogado.token!)
    localStorage.setItem("permissao", usuarioLogado.permisao!)
    localStorage.setItem("user", usuarioLogado.usuario!)
  }

  getToken(){
    return localStorage?.getItem("token");
  }

  getPermissao(){
    return localStorage?.getItem("permissao");
  }

  getUsername(){
    return localStorage?.getItem("user");
  }

  loggout(){
    this.loggedIn.next(false);
    localStorage.setItem("token", "")
    localStorage.setItem("role", "")
    localStorage.setItem("user", "")
  }
}
