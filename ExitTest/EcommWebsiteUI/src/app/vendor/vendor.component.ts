import { Component, OnInit } from '@angular/core';
import { UserService } from '../_services/user.service';

@Component({
  selector: 'app-vendor',
  templateUrl: './vendor.component.html',
  styleUrls: ['./vendor.component.css']
})
export class VendorComponent implements OnInit {
  message;
  constructor(private userService: UserService) { }

  ngOnInit(): void {
    this.forVendor();
  }

  public forVendor(){
    this.userService.forVendor().subscribe(
      (response)=>{
        this.message=response;
        console.log(response);
      },
      (error)=>{
        console.log(error);
      }
    );
  }
}
