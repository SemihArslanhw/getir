package com.getir.business.abstracts;

import java.util.List;

import com.getir.core.utilities.results.DataResult;
import com.getir.core.utilities.results.Result;
import com.getir.entities.concretes.SuperCategory;

public interface SuperCategoryService {

	DataResult<List<SuperCategory>> findAll();
	
	Result add(SuperCategory superCategory);
}
