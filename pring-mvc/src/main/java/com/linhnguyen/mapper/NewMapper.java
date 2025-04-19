package com.linhnguyen.mapper;


import java.sql.ResultSet;
import java.sql.SQLException;

import com.linhnguyen.model.newsModel;

public class NewMapper implements RowMapper<newsModel>{

	@Override
	public newsModel mapRow(ResultSet resultSet) {
		try {
			newsModel news = new newsModel();
			news.setId(resultSet.getLong("id"));
			news.setTitle(resultSet.getString("title"));
			news.setContent(resultSet.getString("content"));
			news.setCategoryId(resultSet.getLong("categoryId"));
			
			news.setThumbnail(resultSet.getString("thumbnail"));
			news.setShortdescription(resultSet.getString("shortdescription"));
			
			if(resultSet.getTimestamp("modifieddate")!=null) {
				news.setModifieddate(resultSet.getTimestamp("modifieddate"));
			}else {
				news.setCreateddate(resultSet.getTimestamp("createddate"));
			}
			if(resultSet.getString("modifiedby")!=null) {
				news.setModifiedby(resultSet.getString("modifiedby"));
			}else {
				news.setCreatedby(resultSet.getString("createdby"));
			}
			return news;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
