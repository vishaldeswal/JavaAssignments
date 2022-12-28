import { FileHandle } from "./file-handle.model";


export interface Product{
  
	productId:number,
    productName:string,
	productDescription:string,
	brandName: string,
	categoryType: string,
	productDicountedPrice: number,
	productActualPrice: number,
	stockQuantity: number,
	productImages: FileHandle[],
	
}