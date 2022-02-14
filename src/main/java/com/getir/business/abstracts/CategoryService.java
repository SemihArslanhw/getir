package com.getir.business.abstracts;

import java.util.List;

import com.getir.core.utilities.results.DataResult;
import com.getir.core.utilities.results.Result;
import com.getir.entities.concretes.Category;

public interface CategoryService {

	
	DataResult<List<Category>> getBySuperCategoryId(int id);
	Result add(Category category);
	
	
}
