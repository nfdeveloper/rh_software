import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { ButtonModule } from 'primeng/button';
import { InputTextModule } from 'primeng/inputtext';
import { LoginRequest } from '../../core/models/auth/login-request.model';
import { AuthService } from '../../core/services/auth.service';
import { MessageService } from 'primeng/api';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [
    CommonModule,
    ReactiveFormsModule,
    InputTextModule,
    ButtonModule
  ],
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss'
})
export class LoginComponent implements OnInit{
  
  loginForms: any = FormGroup;
  login: LoginRequest = new LoginRequest();
  
  constructor(
    private service: AuthService,
    private formBuilder: FormBuilder,
    private messageService: MessageService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.loginForms = this.formBuilder.group({
      username: [this.login.username, [Validators.required]],
      password: [this.login.password, [Validators.required]]
    })
  }

  entrar(){
    this.login = this.loginForms.value;
    this.service.login(this.login).subscribe({
      next: (res) => {
        this.router.navigateByUrl('');
        console.log(res);
        this.service.setDados(res);
      },
      error: (error) => this.messageService.add({
          severity: 'error',
          summary: 'Login erro',
          detail: 'Usuário e/ou senha incorretos.'
        })
      }
    )


  }

}
