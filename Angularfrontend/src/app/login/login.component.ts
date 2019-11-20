import { Component, OnInit } from '@angular/core';
import { Login } from '../login';
import { LoginService } from '../login.service';
import { ActivatedRoute, Router } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {


  login = new Login();

  constructor(private router: Router, private _loginservice:LoginService) { }

  ngOnInit() {

    this.resetForm()
  }
  resetForm(form?: NgForm) {
    if (form != null)
      form.resetForm();

  this._loginservice.formData = {

    userName: '',
    password: '',
    userId: null
  
  }
}
/*
OnSubmit(form: NgForm) {
  console.log("My form : " + form);
  this.loginUser(form);
}
loginUser(form: NgForm) {

  console.log(form.value);
  this._loginservice.getUserId(form.value).subscribe((userData) => {
  this.login = userData;
    console.log(this.login);
    var username = this.login.userName;
    var password = this.login.password;
   
    
    
    /*if (this.login.userId==1)
     {
     
      this.router.navigate(['/viewVendors']);
     }
     else{

      this.router.navigate(['/viewVendors']);

     }
     
   
    }, (error) => {
      console.log(error);
    });*/
  }
  