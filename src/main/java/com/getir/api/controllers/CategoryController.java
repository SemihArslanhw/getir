package com.getir.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.getir.business.abstracts.CategoryService;
import com.getir.business.abstracts.SuperCategoryService;
import com.getir.core.utilities.results.DataResult;
import com.getir.core.utilities.results.Result;
import com.getir.core.utilities.results.SuccesDataResult;
import com.getir.core.utilities.results.SuccessResult;
import com.getir.dataAccess.abstracts.SuperCategoryDao;
import com.getir.entities.concretes.Category;
import com.getir.requests.CategoryCreateRequest;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	CategoryService categoryService;
	SuperCategoryDao superCategoryDao;
    
	@Autowired
	public CategoryController(CategoryService categoryService, SuperCategoryDao superCategoryDao) {
		super();
		this.categoryService = categoryService;
		this.superCategoryDao = superCategoryDao;
	}

	@PostMapping("/add")
	public Result add(@RequestBody CategoryCreateRequest categoryCreateRequest) {
		Category category = new Category();
		category.setCategoryName(categoryCreateRequest.getCategoryName());
		category.setSuperCategory(superCategoryDao.findById(categoryCreateRequest.getSuperCategoryId()).get());
		categoryService.add(category);
		return new SuccessResult("Kategori Eklendi");
	}
	
	@GetMapping("/getCategoriesBySuperCategoryId/{id}")
	public DataResult<List<Category>> getCategoriesBySuperCategoryId(@PathVariable int id){
		return this.categoryService.getBySuperCategoryId(id);
	}
}
