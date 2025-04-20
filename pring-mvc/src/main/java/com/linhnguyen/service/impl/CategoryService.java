package com.linhnguyen.service.impl;

import java.util.List;

import com.linhnguyen.dao.ICategoryDAO;
import com.linhnguyen.dao.impl.CategoryDAO;
import com.linhnguyen.model.categoryModel;
import com.linhnguyen.service.ICategoryService;

public class CategoryService implements ICategoryService{
	private ICategoryDAO categoryDAO;
	public CategoryService() {
		categoryDAO  = new CategoryDAO();
	}

	@Override
	public List<categoryModel> findAll() {
		return categoryDAO.findAll();
	}


}
