import { HttpErrorResponse, HttpInterceptorFn } from '@angular/common/http';
import { inject } from '@angular/core';
import { AuthService } from '../../core/services/auth.service';
import { Router } from '@angular/router';
import { MessageService } from 'primeng/api';
import { catchError, throwError } from 'rxjs';

export const httpInterceptor: HttpInterceptorFn = (req, next) => {
  const tokenService = inject(AuthService);
  const router = inject(Router);
  const messageService = inject(MessageService);

  let token = tokenService.getToken();
 
  if(token) {
    req = req.clone({
      setHeaders: {
        Authorization: `Bearer ${token}`
      }
    })
  }
  
  return next(req).pipe(
    catchError((e: HttpErrorResponse) => {
      if(e.status === 403){
        tokenService.loggout();
        router.navigateByUrl('');
        messageService.add({
          severity: 'warn',
          summary: 'Sessão Expirada',
          detail: 'Faça o Login novamente para continuar.'
        })
      }
      else {
        messageService.add({
          severity: 'warn',
          summary: 'Erro',
          detail: e.error.message
        })
      }

      const error = e.error?.message || e.statusText;
      return throwError(() => error)
    })
  );
};
