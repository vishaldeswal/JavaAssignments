import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Product } from '../_model/product.model';

@Component({
  selector: 'app-product-view-details',
  templateUrl: './product-view-details.component.html',
  styleUrls: ['./product-view-details.component.css']
})
export class ProductViewDetailsComponent implements OnInit {

  selectedProductIndex = 0 ;
	product: Product;
  constructor(private activateRoute: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.product= this.activateRoute.snapshot.data['product'];
		console.log(this.product)
  }

  changeIndex(index){
		this.selectedProductIndex= index;
	}

  buyProduct(productId){
    this.router.navigate(['/buyProduct',{
      isSingleProductCheckout:true, id:productId
    }]);
  }

  public  isOutOfStock(quantity): boolean{
    if(quantity>0){
      return false;
    }
    else{
      return true;
    }
  }
}
