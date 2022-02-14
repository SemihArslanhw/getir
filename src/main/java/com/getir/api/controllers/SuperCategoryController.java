package com.getir.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.getir.business.abstracts.SuperCategoryService;
import com.getir.core.utilities.results.DataResult;
import com.getir.core.utilities.results.Result;
import com.getir.core.utilities.results.SuccesDataResult;
import com.getir.core.utilities.results.SuccessResult;
import com.getir.entities.concretes.SuperCategory;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/supercategories")
public class SuperCategoryController {

	SuperCategoryService superCategoryService;

	@Autowired
	public SuperCategoryController(SuperCategoryService superCategory) {
		super();
		this.superCategoryService = superCategory;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody SuperCategory superCategory) {
		
		superCategoryService.add(superCategory);
		return new SuccessResult("Başarıyla Oluşturuldu" );
	}
	
	@GetMapping("/getAllSuperCategories")
	public DataResult<List<SuperCategory>> getAllSuperCategories(){
		return superCategoryService.findAll();
	}
	
	
}
