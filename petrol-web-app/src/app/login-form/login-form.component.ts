import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { UsernameValidator } from './login-form.Validator';

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})

export class LoginFormComponent implements OnInit {

	loginForm = new FormGroup({
		userName: new FormControl('', 
			[Validators.required, 
			 Validators.minLength(3),
			 Validators.maxLength(100),
			 Validators.pattern("[a-z0-9_-]*")], 
			UsernameValidator.isDuplicateUserName),
		passWord: new FormControl('', Validators.required)
	});

  constructor() { }

  ngOnInit(): void {
  }

  get userName() {
	  return this.loginForm.get('userName');
  }

  login() {
	if (this.userName.value === "deepak2") {
		this.loginForm.setErrors({invalidLogin: true})
  	} 
  }
  
}
