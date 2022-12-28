import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ShowProductImagesDialogComponent } from '../show-product-images-dialog/show-product-images-dialog.component';
import { Product } from '../_model/product.model';
import { ProductService } from '../_services/product.service';
import { UserAuthService } from '../_services/user-auth.service';
import {ImageProcessingServiceService} from '../image-processing-service.service';
import { map } from 'rxjs';
import { Router } from '@angular/router';

@Component({
  selector: 'app-show-product-details',
  templateUrl: './show-product-details.component.html',
  styleUrls: ['./show-product-details.component.css']
})
export class ShowProductDetailsComponent implements OnInit {


  productDetails:Product[]=[];
  displayedColumns: string[] = ['Id', 'Product Name', 'Description', 'Brand','Category','Dicounted Price','Actual Price','Stock Quantity','Actions'];
  constructor(private productService: ProductService,
    private userAuthService: UserAuthService,
    public imagesDialog: MatDialog,
    private imageProcessingService:ImageProcessingServiceService,
    private router: Router) { }

  ngOnInit(): void {
    this.getAllProduct();
  }






public getAllProduct(){
  const roles: any[] =this.userAuthService.getRoles();
  const role:string =roles[0].roleName;

   
  if(role==='Admin')
   {
    this.productService.getAllProducts().pipe(
      map((x:Product[],i)=>x.map((product:Product)=> this.imageProcessingService.createImages(product)))
    )
    .subscribe(
      (resp:Product[])=>{
        console.log(resp);
        this.productDetails=resp;
      },
      (error: HttpErrorResponse)=>{
        console.log(error);
      }
  );
   }

   else{
    this.productService.getVendorProducts().pipe(
      map((x:Product[],i)=>x.map((product:Product)=> this.imageProcessingService.createImages(product)))
    )
    .subscribe(
      (resp:Product[])=>{
        console.log(resp);
        this.productDetails=resp;
      },
      (error: HttpErrorResponse)=>{
        console.log(error);
      }
  );
   }
 
}



deleteProduct(productId){
  console.log(productId);
  this.productService.deleteProduct(productId).subscribe(
    (response)=>{
      let message: string= response;
      if(message ===''){

      }
      else{
        alert(message);
      }
      this.getAllProduct();
      
    },
    (error: HttpErrorResponse)=>{
      console.log("error",error) ;  
     }
  );
 
}
showImages(product: Product){
  console.log(product);
  this.imagesDialog.open(ShowProductImagesDialogComponent,{
    data:{
      images: product.productImages
    },
    height:'500px',
    width:'800px'
  });


}
editProductDetails(productId){
  this.router.navigate(['/addNewProduct', {productId: productId}]);

}

public isQuantityEmpty(quantity:any){
  if(quantity===0){
    return true;
  }
  else{
    return false;
  }

}
}
