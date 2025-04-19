package com.linhnguyen.mapper;


import java.sql.ResultSet;

import com.linhnguyen.model.categoryModel;

public class categoryMapper implements RowMapper<categoryModel> {

	@Override
	public categoryModel mapRow(ResultSet resultSet) {
		categoryModel category = new categoryModel();
		 try {
			 category.setId(resultSet.getLong("id"));
			 category.setCode(resultSet.getString("code"));
			 category.setName(resultSet.getString("name"));

		} catch (Exception e) {
			return null;
		}
		return category;
	}

}
