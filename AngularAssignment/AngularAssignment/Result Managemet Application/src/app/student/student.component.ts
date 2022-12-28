import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Student } from './student.model';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { RestService } from '../rest.service';
import { Result } from '../Result';


@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent implements OnInit {

  student: Result[] = [];
  i: number = 0;
  auth: boolean = false;


  constructor(private http: HttpClient, private router: Router, private rs: RestService, private acvrt: ActivatedRoute) { }

  ngOnInit(): void {

  }
  getData(form: NgForm) {
    const post: Student = {
      id: form.value.id,
      dob: form.value.dob
    }

    this.rs.getResults().subscribe
      (
        (response) => {
          this.student = response;
          for (this.i; this.i < this.student.length; this.i++) {
            console.log("response[this.i].dob =",response[this.i].dob ,"|| post.dob=",post.dob,"|| response[this.i].id =",response[this.i].id ,"post.id=",post.id);
            if (response[this.i].dob === post.dob && response[this.i].id === post.id) {
              alert('Search Successfull');
              this.auth = true;
              this.router.navigate(['StudentResult/' + post.id + '/' + post.dob]);
              break;
            }
            
          }
          if (this.i == this.student.length && this.auth == false) {
            window.location.reload();
            alert(' enter valid details ');
          }
        },
        (error) => console.log(error)
      );
    console.warn(post)
  }
}
