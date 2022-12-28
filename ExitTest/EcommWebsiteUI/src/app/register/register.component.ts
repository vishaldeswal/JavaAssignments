import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from '../_services/user.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  constructor(private userService: UserService,
    private router: Router) { }

  ngOnInit(): void {
  }

  registerUser(registerUserForm: NgForm){
    console.log(registerUserForm.value);

    this.userService.registerUser(registerUserForm.value).subscribe(
      (resp)=>{
        alert("Successfully register.");
        this.router.navigate(['/login'])
        console.log(resp);
      },
      (err)=>{
        console.log(err);
      }
    );

  }
}
