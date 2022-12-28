import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, Resolve, RouterStateSnapshot } from '@angular/router';
import { map, Observable, of } from 'rxjs';
import { ImageProcessingServiceService } from './image-processing-service.service';
import { Product } from './_model/product.model';
import { ProductService } from './_services/product.service';

@Injectable({
  providedIn: 'root'
})
export class ProductResolveService implements Resolve<Product> {

  constructor(private productService: ProductService,
    private imageProcessingService: ImageProcessingServiceService) { }
  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<Product> {
    
    const id= route.paramMap.get("productId");

    if(id){
      //fetch details from backend
      return this.productService.getProductDetailsById(id).pipe(
        map(p => this.imageProcessingService.createImages(p))
      );
    }
    else{
      //retur empty product observable
      return of(this.getProductDetails());
    }

    
  }

  getProductDetails(){
    return {
    productId:null,
    productName: "",
    productDescription: "",
    brandName: "",
    categoryType: "",
    productDicountedPrice: 0,
    productActualPrice: 0,
    stockQuantity: 0,
    productImages: []
    };
  }
}
