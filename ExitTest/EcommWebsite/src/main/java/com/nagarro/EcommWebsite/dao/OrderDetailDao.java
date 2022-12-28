package com.nagarro.EcommWebsite.dao;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nagarro.EcommWebsite.entity.OrderDetail;
import com.nagarro.EcommWebsite.entity.SalesReportResult;

public interface OrderDetailDao extends JpaRepository<OrderDetail, Integer> {

@Query(value="select  o.product_product_id, p.product_name, SUM(o.order_amount) from order_detail o INNER JOIN product p on p.product_id=o.product_product_id where p.brand_name= :brandName and p.category_type=:categoryType and o.order_date >= :startDate  and o.order_date <= :endDate and p.vendor_username=:username  group by( o.product_product_id)" ,nativeQuery=true)
public ArrayList<ArrayList<String>> getSalesReport(String brandName, String categoryType, Date startDate, Date endDate, String username);

}
