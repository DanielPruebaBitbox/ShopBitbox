import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { AuthenticationService } from './auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  USER_NAME_SESSION_ATTRIBUTE_NAME = 'authenticatedUser';
  email: string;
  password : string;
  id: number;
  errorMessage = 'Invalid Credentials';
  successMessage: string;
  invalidLogin = false;
  loginSuccess = false;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private authenticationService: AuthenticationService) {   }

  ngOnInit() {
  }

  handleLogin() {
    this.authenticationService.authenticationService(this.email, this.password).subscribe((result)=> {
      this.invalidLogin = false;
      this.loginSuccess = true;
      this.successMessage = 'Login Successful.';
      sessionStorage.setItem(this.USER_NAME_SESSION_ATTRIBUTE_NAME, Date.now().toString());

      this.router.navigate(['/home']);
    }, (error) => {
      this.invalidLogin = true;
      this.loginSuccess = false;
    });
  }
}
