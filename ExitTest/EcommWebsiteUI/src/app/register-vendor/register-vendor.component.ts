import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from '../_services/user.service';

@Component({
  selector: 'app-register-vendor',
  templateUrl: './register-vendor.component.html',
  styleUrls: ['./register-vendor.component.css']
})
export class RegisterVendorComponent implements OnInit {

  constructor(private userService: UserService,
    private router: Router) { }

  ngOnInit(): void {
  }
  registerVendor(registerVendorForm: NgForm){
    console.log(registerVendorForm.value);

    this.userService.registerVendor(registerVendorForm.value).subscribe(
      (resp)=>{
        alert("Successfully register vendor.");
        this.router.navigate(['/login'])
        
      },
      (err)=>{
        console.log(err);
      }
    );

  }
}
