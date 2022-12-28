import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { UserAuthService } from '../_services/user-auth.service';
import { UserService } from '../_services/user.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private userService: UserService,
              private userAuthService: UserAuthService,
              private router: Router ) { }

  ngOnInit(): void {
  }
  login(loginForm : NgForm){
    this.userService.login(loginForm.value).subscribe(
      (response :any)=>{
        console.log(response);
        

        this.userAuthService.setRoles(response.user.role);
        this.userAuthService.setToken(response.jwtToken);
        this.userAuthService.setUserName(response.user.userName);
       

        const role=response.user.role[0].roleName;
        if(role == 'Admin'){
            this.router.navigate(['/admin']);
        }
        else if(role == 'Vendor'){
          this.router.navigate(['/vendor']);
        }
        else{
          this.router.navigate(['/user']);
        }
      },
      (err :HttpErrorResponse)=>{
        console.log(err.status);
                    if(err.status===401){
                        alert("User doesn't exist ");
                        this.router.navigate(['/login']);
                    }
                    
      }
    );
  }

  public registerUser(){
    this.router.navigate(['/register']);
  }

  public registerVendor(){
    this.router.navigate(['/registerVendor']);
  }
}
