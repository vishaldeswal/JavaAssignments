import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Teacher } from './teacher.model';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { RestService } from '../rest.service';

@Component({
  selector: 'app-teacher',
  templateUrl: './teacher.component.html',
  styleUrls: ['./teacher.component.css']
})
export class TeacherComponent implements OnInit {

  teacher: Teacher[] = [];
  i: number = 0;
  auth: boolean = false;
  constructor(private http: HttpClient, private router: Router, private rs: RestService) { }
  ngOnInit(): void {
  }

  getData(form: NgForm) {
    const details: Teacher = {
      user: form.value.user,
      pass: form.value.pass
    }
    console.warn(details)
    this.rs.getTeachers().subscribe(res => {
      console.log(res);
      for (this.i; this.i < res.length; this.i++) {
        if (res[this.i].user === details.user && res[this.i].pass === details.pass) {
          alert(' success ');
          this.auth = true;
          localStorage.setItem("isAuth",this.auth.toString());
          this.goToPage('Result');
          break;
        }
      }
      if (this.i == res.length && this.auth == false) {
        window.location.reload();
        // this.goToPage('Teacher');
        alert(' enter valid username and password ');
      }
    })
  }
  goToPage(pageName: string): void {
    this.router.navigate([`${pageName}`]);
  }


}
