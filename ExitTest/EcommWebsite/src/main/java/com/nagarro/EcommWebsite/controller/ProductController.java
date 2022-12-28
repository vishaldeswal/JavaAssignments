package com.nagarro.EcommWebsite.controller;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.nagarro.EcommWebsite.entity.ImageModel;
import com.nagarro.EcommWebsite.entity.Product;
import com.nagarro.EcommWebsite.service.ProductService;

@RestController
@CrossOrigin(origins="*")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	
	@PostMapping(value={"/addNewProduct"}, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
	@PreAuthorize("hasAnyRole('Admin','Vendor')")
	public Product addNewProduct(@RequestPart("product") Product product,@RequestPart("imageFile") MultipartFile[] file,@RequestParam String vendorUserName ) {
	//	return productService.addNewProduct(product,vendorUserName);
		
		try {
			Set<ImageModel> images=uploadImage(file);
			product.setProductImages(images);
			return productService.addNewProduct(product,vendorUserName);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		
	}
	
	public Set<ImageModel> uploadImage(MultipartFile[] multiPartFiles) throws IOException {
		Set<ImageModel> imageModels = new HashSet<>();
		
		for(MultipartFile file: multiPartFiles) {
			ImageModel imageModel = new ImageModel(
					file.getOriginalFilename(),
					file.getContentType(),
					file.getBytes()
					);
			imageModels.add(imageModel);
		}
		return imageModels;
	}
	
	
	@GetMapping({"/getAllProducts"})
	public List<Product> getAllProducts(){
		return productService.getAllProducts();
	}
	
	@GetMapping({"/getVendorProducts"})
	@PreAuthorize("hasRole('Vendor')")
	public List<Product> getVendorProducts(){
		return productService.getVendorProducts();
	}
	
	
	@DeleteMapping({"/deleteProductDetails/{productId}"})
	@PreAuthorize("hasAnyRole('Admin','Vendor')")
	public String deleteProductDetails(@PathVariable("productId") Integer productId) {
		return productService.deleteProductDetails(productId);
	}
	
	@GetMapping("/getProductDeatilsById/{productId}")
	public Product getProductDeatilsById(@PathVariable("productId") Integer productId) {
		return productService.getProductDeatilsById(productId);
	}
	
	@GetMapping({"/getProductDetails/{isSingleProductCheckout}/{productId}"})
	@PreAuthorize("hasRole('User')")
	public List<Product> getProductDetails(@PathVariable(name="isSingleProductCheckout") boolean isSingleProductCheckout,@PathVariable(name="productId") Integer productId){
		
		return productService.getProductDetails(isSingleProductCheckout, productId);
	}
	
	@GetMapping("/getBrandName")
	@PreAuthorize("hasRole('Vendor')")
	public List<String> getBrandName(){
		return productService.getBrandName();
	}
	
	@GetMapping("/getCategoryName")
	@PreAuthorize("hasRole('Vendor')")

	public List<String> getCategoryName(){
		return productService.getCategoryName();
	}
	
}
