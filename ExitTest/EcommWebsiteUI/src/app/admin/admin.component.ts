import { Component, OnInit } from '@angular/core';
import { UserService } from '../_services/user.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {
  message;
  constructor(private userService: UserService) { }

  ngOnInit(): void {
    this.forAdmin();
  }

  public forAdmin(){
    this.userService.forAdmin().subscribe(
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
