import { Injectable } from '@angular/core';
import { Login } from './login';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  
  formData:Login;

  constructor(private _httpService:HttpClient) { }

  getUserId(formData: any):any{
    return this._httpService.get<Login>(environment.APIUrl +'/api/login/' +formData +'/'+ formData.password);

  }
}
