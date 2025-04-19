package com.linhnguyen.dao;


import java.util.List;

import com.linhnguyen.model.categoryModel;

public interface ICategoryDAO extends GenericDAO<categoryModel>{
	List<categoryModel> findAll(); 
	categoryModel findOne(Long id);
	categoryModel findOneByCode(String code);
}
