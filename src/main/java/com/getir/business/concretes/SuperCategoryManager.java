package com.getir.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.getir.business.abstracts.SuperCategoryService;
import com.getir.core.utilities.results.DataResult;
import com.getir.core.utilities.results.Result;
import com.getir.core.utilities.results.SuccesDataResult;
import com.getir.core.utilities.results.SuccessResult;
import com.getir.dataAccess.abstracts.SuperCategoryDao;
import com.getir.entities.concretes.Category;
import com.getir.entities.concretes.SuperCategory;

@Service
public class SuperCategoryManager implements SuperCategoryService{

	
	SuperCategoryDao superCategoryDao;
	
	
	
	@Autowired
	public SuperCategoryManager(SuperCategoryDao superCategoryDao) {
		super();
		this.superCategoryDao = superCategoryDao;
	}
	


	@Override
	public DataResult<List<SuperCategory>> findAll() {
		return new SuccesDataResult<List<SuperCategory>>
		(this.superCategoryDao.findAll());
	}



	@Override
	public Result add(SuperCategory superCategory) {
		this.superCategoryDao.save(superCategory);
		return new SuccessResult("Başarıyla Oluşturuldu");
	}



	




	
	
	
}
