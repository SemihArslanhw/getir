package com.getir.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.getir.business.abstracts.ProductService;
import com.getir.core.utilities.results.DataResult;
import com.getir.core.utilities.results.Result;
import com.getir.core.utilities.results.SuccesDataResult;
import com.getir.core.utilities.results.SuccessResult;
import com.getir.dataAccess.abstracts.ProductDao;
import com.getir.entities.concretes.Product;
import com.getir.entities.dtos.ProductWithCategoryDto;

@Service
public class ProductManager implements ProductService{

	private ProductDao productDao;
	
	
	@Autowired
	public ProductManager(ProductDao productDao) {
		super();
		this.productDao = productDao;
	}



	@Override
	public DataResult<List<Product>> getAll() {
		// TODO Auto-generated method stub
		return new SuccesDataResult<List<Product>>
		(this.productDao.findAll(),"Data Listelendi");
	}



	@Override
	public Result add(Product product) {
		this.productDao.save(product);
		return new SuccessResult("Ürün Eklendi");
	}



	@Override
	public DataResult<Product> getByProductName(String productName) {
		// TODO Auto-generated method stub
		return new SuccesDataResult<Product>
		(this.productDao.getByProductName(productName),"Data Listelendi");
	}



	@Override
	public DataResult<Product> getByProductNameAndCategory(String productName, int categoryId) {
		// TODO Auto-generated method stub
		return new SuccesDataResult<Product>
		(this.productDao.getByProductNameAndCategory_CategoryId(productName,categoryId),"Data Listelendi");
	}





	@Override
	public DataResult<List<Product>> getByProductNameContains(String productName) {
		// TODO Auto-generated method stub
		return new SuccesDataResult<List<Product>>
		(this.productDao.getByProductNameContains(productName));
	}



	@Override
	public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
		// TODO Auto-generated method stub
		return new SuccesDataResult<List<Product>>
		(this.productDao.getByProductNameStartsWith(productName));
	}



	@Override
	public DataResult<List<Product>> getByNameAndCategory(String name, int categoryId) {
		// TODO Auto-generated method stub
		return new SuccesDataResult<List<Product>>
		(this.productDao.getByNameAndCategory(name,categoryId));
	}



	@Override
	public DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories) {
		// TODO Auto-generated method stub
		return new SuccesDataResult<List<Product>>
		(this.productDao.getByCategory_CategoryIdIn(categories),"Data Listelendi");
	}



	@Override
	public DataResult<List<Product>> getAll(int pageNo, int pageSize) {
		
		Pageable pageable = PageRequest.of(pageNo - 1 , pageSize);
		
		return new SuccesDataResult<List<Product>>
		(this.productDao.findAll(pageable).getContent());
	}



	@Override
	public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
		// TODO Auto-generated method stub
		return null;
	}


}
