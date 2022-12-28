import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RestService } from '../rest.service';
import { Result } from '../Result';

@Component({
  selector: 'app-result-list',
  templateUrl: './result-list.component.html',
  styleUrls: ['./result-list.component.css']
})
export class ResultListComponent implements OnInit {

  constructor(private rs:RestService,private router:Router) { }

  columns=["Roll No","Name","Date of Birth","Score"];
  index=["id","name","dob","score"];
  total:number=0;

  result:Result[]=[];


  ngOnInit(): void {

    this.rs.getResults().subscribe
    (
      (response)=>
      {
        this.result = response;
        for (this.total; this.total < this.result.length; this.total++) {
        }
      },
      (error) => console.log(error)
    );
  }
  goToPage(pageName:string):void{
    this.router.navigate([`${pageName}`]);
  }

  onDelete(id:number){
    console.warn(id);
    this.rs.deleteResult(id).subscribe(
      (result)=>{
        console.warn("result",result);
        this.ngOnInit();
      }
    );
  }
  onUpdate(id:number){
    this.router.navigate(['UpdateResult/'+id]);
    
  }
  logOut(){
    localStorage.removeItem("isAuth");
    this.router.navigate(['']);

  }
}
