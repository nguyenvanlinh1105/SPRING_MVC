package com.linhnguyen.dao.impl;

import java.util.List;

import com.linhnguyen.dao.ICategoryDAO;
import com.linhnguyen.mapper.NewMapper;
import com.linhnguyen.mapper.categoryMapper;
import com.linhnguyen.model.categoryModel;
import com.linhnguyen.model.newsModel;

public class CategoryDAO extends AbstractDAO<categoryModel> implements ICategoryDAO {

	@Override
	public List<categoryModel> findAll() {
		String sql = "select * from category";
		return query(sql, new categoryMapper());
	}

	public categoryModel findOne(Long id) {
		String sql = "select * from category where id = ?";
		List<categoryModel> category = query(sql, new categoryMapper(), id);
		    if (!category.isEmpty()) {
		        return category.get(0);
		    }
		    return null; 
		}

	@Override
	public categoryModel findOneByCode(String code) {
		String sql = "select * from category where code = ?";
		List<categoryModel> category = query(sql, new categoryMapper(), code);
		    if (!category.isEmpty()) {
		        return category.get(0);
		    }
		    return null; 
		}


	
}
