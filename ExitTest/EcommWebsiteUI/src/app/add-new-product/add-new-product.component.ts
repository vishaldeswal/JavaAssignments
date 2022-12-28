import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { DomSanitizer } from '@angular/platform-browser';
import { ActivatedRoute } from '@angular/router';

import { FileHandle } from '../_model/file-handle.model';
import { Product } from '../_model/product.model';

import { ProductService } from '../_services/product.service';
import { UserAuthService } from '../_services/user-auth.service';

@Component({
  selector: 'app-add-new-product',
  templateUrl: './add-new-product.component.html',
  styleUrls: ['./add-new-product.component.css']
})
export class AddNewProductComponent implements OnInit {
  isNewProduct= true;
  product: Product = {
    productId:null,
    productName: "",
    productDescription: "",
    brandName: "",
    categoryType: "",
    productDicountedPrice: 0,
    productActualPrice: 0,
    stockQuantity: 0,
    productImages: []

  }

  constructor(private productService: ProductService,
    private sanitizer: DomSanitizer,
    private userAuthService: UserAuthService,
    private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.product= this.activatedRoute.snapshot.data['product'];
    
    if(this.product && this.product.productId){
        this.isNewProduct=false;
    }
  }

 
  
  public addProduct(productForm: NgForm) {


    const productFormData = this.prepareFormData(this.product);

    this.productService.addProduct(productFormData).subscribe(
      (response: Product) => {
        productForm.reset();
        this.product.productImages = [];
        alert("Product Added successfully");
      },
      (error: HttpErrorResponse) => {
        console.log(error);
      }
    );
  }


  prepareFormData(product: Product): FormData {
    const formData = new FormData();

    formData.append(
      'product',
      new Blob([JSON.stringify(product)], { type: 'application/json' })
    );
    for (var i = 0; i < product.productImages.length; i++) {
      formData.append(
        'imageFile',
        product.productImages[i].file,
        product.productImages[i].file.name
      );
    }
    return formData;
  }

  onFileSelected(event) {

    if (event.target.files) {
      const fileUploaded = event.target.files[0];

      const fileHandle: FileHandle = {
        file: fileUploaded,
        url: this.sanitizer.bypassSecurityTrustUrl(
          window.URL.createObjectURL(fileUploaded)
        )
      };

      this.product.productImages.push(fileHandle);

    }
  }

  removeImages(i: number) {
    this.product.productImages.splice(i, 1);
  }
}
