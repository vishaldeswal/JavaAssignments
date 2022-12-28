import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { map } from 'rxjs';
import { ImageProcessingServiceService } from '../image-processing-service.service';
import { Product } from '../_model/product.model';
import { ProductService } from '../_services/product.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  productDetails=[]; 
  constructor(private productService: ProductService,
              private imageProcessingService: ImageProcessingServiceService,
              private router: Router) { }

  ngOnInit(): void {
    this.getAllProduct();
  }

  public getAllProduct(){

    this.productService.getAllProducts().pipe(
      map((x:Product[],i)=>x.map((product:Product)=> this.imageProcessingService.createImages(product)))
    )
    .subscribe(
      (resp:Product[])=>{
        
        this.productDetails=resp;
      },
      (error: HttpErrorResponse)=>{
        console.log(error);
      }
  );
  }

  showProductDetails(productId){
    this.router.navigate(['/productViewDetails',{productId : productId}]);
  }


}
