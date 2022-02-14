package com.getir.requests;

public class CategoryCreateRequest {

	String categoryName;
	int superCategoryId;
	
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public int getSuperCategoryId() {
		return superCategoryId;
	}
	public void setSuperCategoryId(int superCategoryId) {
		this.superCategoryId = superCategoryId;
	}
	
}
