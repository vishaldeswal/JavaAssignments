import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RestService } from '../rest.service';
import { ActivatedRoute } from '@angular/router';
import { FormControl, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-update-result',
  templateUrl: './update-result.component.html',
  styleUrls: ['./update-result.component.css']
})
export class UpdateResultComponent implements OnInit {
  constructor(private http:HttpClient,private router:Router,private rs:RestService,private acvrt:ActivatedRoute) { }

editResult=new FormGroup({
  id:new FormControl(),
  name:new FormControl(),
  dob:new FormControl(),
  score:new FormControl()
})

  ngOnInit(): void {
    console.warn(this.acvrt.snapshot.params['id'])
    this.rs.getResult(this.acvrt.snapshot.params['id']).
    subscribe((result)=>{
      this.editResult.setValue(result);
    });
  }

  getData(){
    console.warn(this.editResult.value);
    
    this.rs.updateResult(this.acvrt.snapshot.params['id'],this.editResult.value).
    subscribe((result)=>{
       console.log(result,"data updated successfully");
      
    });

    this.router.navigate(['Result']).then(() => {
      window.location.reload();
    });

}
}
