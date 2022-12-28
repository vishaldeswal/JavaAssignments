package com.nagarro.EcommWebsite.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nagarro.EcommWebsite.entity.Product;

@Repository
public interface ProductDao extends JpaRepository<Product,Integer> {
	
	@Modifying
	@Query("Delete From Product p WHERE p.productId= :id")
	void deleteById(@Param("id") Integer id);
	
	@Query(value="SELECT * FROM PRODUCT WHERE vendor_username=:vendorUserName", nativeQuery=true)
	List<Product> findProductByVendorName(String vendorUserName);
	
	
	@Query(value="select distinct(brand_name) from product;", nativeQuery=true)
	 List<String> getBrandName();
	

	@Query(value="select distinct(category_type) from product;", nativeQuery=true)
	 List<String> getCategoryName();
}
