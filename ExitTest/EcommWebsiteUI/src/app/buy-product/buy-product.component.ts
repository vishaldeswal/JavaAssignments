import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { OrderDetails } from '../_model/order-details.model';
import { Product } from '../_model/product.model';
import { ProductService } from '../_services/product.service';

@Component({
  selector: 'app-buy-product',
  templateUrl: './buy-product.component.html',
  styleUrls: ['./buy-product.component.css']
})
export class BuyProductComponent implements OnInit {
  productDetails: Product[] = [] ;
  quantityBuyOption:number[]=[];
  
  orderDetails: OrderDetails = {
  fullName: '',
  fullAddress: '',
  contactNumber: '',
  alternateContactNumber:'',
  orderProductQuantityList: []

}
  constructor(private activatedRoute: ActivatedRoute,
    private productService: ProductService,
    private router: Router) { }

  ngOnInit(): void {
    this.productDetails=this.activatedRoute.snapshot.data['productDetails'];
    
    for(let i:number=1; i<=this.productDetails[0].stockQuantity; i++){
      this.quantityBuyOption.push(i);
    }

    this.productDetails.forEach(
      x => this.orderDetails.orderProductQuantityList.push(
        {productId: x.productId, quantity: 1}
       )
       );
  }

  public placeOrder(orderForm : NgForm){
      this.productService.placeOrder(this.orderDetails).subscribe(
        (resp) => {
          console.log(resp);
          orderForm.reset();
          this.router.navigate(['/orderConfirm'])
        },
        (err)=>{
          console.log(err);
        }
      );
  }

  public getQuantityForProduct(productId){
    const filteredProduct=this.orderDetails.orderProductQuantityList.filter(
      (productQuantity) => productQuantity.productId === productId
    );

    return filteredProduct[0].quantity;
  }

  public getCalculatedTotal(productId, productDicountedPrice){
    const filteredProduct=this.orderDetails.orderProductQuantityList.filter(
      (productQuantity) => productQuantity.productId === productId
    );

    return filteredProduct[0].quantity * productDicountedPrice;
  }

  onQuantityChanged(quantity,productId){
    this.orderDetails.orderProductQuantityList.filter(
      (orderProduct) => orderProduct.productId === productId
    )[0].quantity = quantity;
  }
}
