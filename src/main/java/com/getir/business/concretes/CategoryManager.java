package com.getir.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.getir.business.abstracts.CategoryService;
import com.getir.core.utilities.results.DataResult;
import com.getir.core.utilities.results.Result;
import com.getir.core.utilities.results.SuccesDataResult;
import com.getir.core.utilities.results.SuccessResult;
import com.getir.dataAccess.abstracts.CategoryDao;
import com.getir.entities.concretes.Category;


@Service
public class CategoryManager implements CategoryService{

	CategoryDao categoryDao;
	
	
	@Autowired
	public CategoryManager(CategoryDao categoryDao) {
		super();
		this.categoryDao = categoryDao;
	}

	@Override
	public DataResult<List<Category>> getBySuperCategoryId(int id) {
		return new SuccesDataResult<List<Category>>
		(this.categoryDao.getBySuperCategory_CategoryId(id));
	}

	@Override
	public Result add(Category category) {
		this.categoryDao.save(category);
		return new SuccessResult("Categori Eklendi");
	}

	
	
}
