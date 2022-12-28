import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { OrderDetails } from '../_model/order-details.model';
import { Product } from '../_model/product.model';
import { UserAuthService } from './user-auth.service';



@Injectable({
  providedIn: 'root'
})
export class ProductService {
  PATH_OF_API = "http://localhost:4001";
  constructor( private httpClient: HttpClient,
              private userAuthService : UserAuthService ) { }

  public addProduct(product: FormData){
    const username= this.userAuthService.getUserName();
    let httpParams = new HttpParams().append("vendorUserName", username)
    return this.httpClient.post<Product>(this.PATH_OF_API + "/addNewProduct", product,{params:httpParams});
  }

  public getAllProducts(){
    return this.httpClient.get<Product[]>(this.PATH_OF_API+"/getAllProducts");
  }

  public getVendorProducts(){
    return this.httpClient.get<Product[]>(this.PATH_OF_API+"/getVendorProducts");
  }

  public deleteProduct(productId: number){
   return  this.httpClient.delete(this.PATH_OF_API+"/deleteProductDetails/"+productId, { responseType: 'text' });
  }

  public getProductDetailsById(productId){
    return this.httpClient.get<Product>(this.PATH_OF_API+"/getProductDeatilsById/"+productId);
  }

  public getProductDetails(isSingleProductCheckout, productId){
    return this.httpClient.get(this.PATH_OF_API+"/getProductDetails/"+isSingleProductCheckout+"/"+productId);
  }

  public placeOrder(orderDetails: OrderDetails){
    return this.httpClient.post(this.PATH_OF_API+"/placeOrder", orderDetails);
  }

  public getBrandName(){
    return this.httpClient.get<[]>(this.PATH_OF_API+"/getBrandName")
  }

  public getCategoryName(){
    return this.httpClient.get<[]>(this.PATH_OF_API+"/getCategoryName")
  }

  public getSalesReport(brandName, categoryType, startDate, endDate){
    return this.httpClient.get<[]>(this.PATH_OF_API+"/getSalesReport/"+brandName+"/"+categoryType+"/"+startDate+"/"+endDate);
  }
}
