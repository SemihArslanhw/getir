package com.getir.business.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.getir.core.utilities.results.DataResult;
import com.getir.core.utilities.results.Result;
import com.getir.entities.concretes.Product;
import com.getir.entities.dtos.ProductWithCategoryDto;


public interface ProductService {

	DataResult<List<Product>> getAll();
	DataResult<List<Product>> getAll(int pageNo , int pageSize);
	Result add(Product product);
	
    DataResult<Product> getByProductName(String productName);
	
    DataResult<Product> getByProductNameAndCategory(String productName , int categoryId);
	
	DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories);
	
	DataResult<List<Product>> getByProductNameContains(String productName);
	
	DataResult<List<Product>> getByProductNameStartsWith(String productName);
	
	DataResult<List<Product>> getByNameAndCategory(String name , int categoryId);
    
	DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails(); 

	
	//@Query("From Product where productName=:productName and categoryId=:categoryId")
}
