import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { RestService } from '../rest.service';

@Component({
  selector: 'app-student-result',
  templateUrl: './student-result.component.html',
  styleUrls: ['./student-result.component.css']
})
export class StudentResultComponent implements OnInit {

  showResult=new FormGroup({
    id:new FormControl(),
    name:new FormControl(),
    dob:new FormControl(),
    score:new FormControl()
  })

  constructor(private http:HttpClient,private router:Router,private rs:RestService,private acvrt:ActivatedRoute) { }

  ngOnInit(): void {
    console.warn(this.acvrt.snapshot.params['id'])
    console.warn(this.acvrt.snapshot.params['dob'])
    this.rs.getResult(this.acvrt.snapshot.params['id']).
    subscribe(result=>{
  this.showResult.setValue(result);
    });

  }

}
