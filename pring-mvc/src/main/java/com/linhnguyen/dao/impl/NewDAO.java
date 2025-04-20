package com.linhnguyen.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.linhnguyen.dao.INewDAO;
import com.linhnguyen.mapper.NewMapper;
import com.linhnguyen.model.newsModel;
import com.linhnguyen.paging.Pageble;

@Repository
public class NewDAO extends AbstractDAO<newsModel> implements INewDAO {

	@Override
	public List<newsModel> findByCategoryId(Long categoryId) {
		
		String sql = "select * from news WHERE categoryid =?";
		return query(sql, new NewMapper(), categoryId);
	}

	@Override
	public Long save(newsModel newModel) {
		String sql = "insert into  news (title, content,thumbnail,shortdescription,categoryid, createddate,createdby) VALUES(?,?,?,?,?,?,?)";
		return insert(sql, newModel.getTitle(), newModel.getContent(), newModel.getThumbnail(), newModel.getShortdescription(),newModel.getCategoryId(), newModel.getCreateddate(), newModel.getCreatedby());
			
		
	}

	@Override

	public newsModel findOne(Long id) {
		String sql = "select * from news WHERE id = ?";
		List<newsModel> newsList = query(sql, new NewMapper(), id);
		    if (!newsList.isEmpty()) {
		        return newsList.get(0);
		    }
		    return null; 
		}

	@Override
	public void update(newsModel updateNew) {
		StringBuilder sql = new StringBuilder("UPDATE news SET title = ?, thumbnail = ?,");
		sql.append(" shortdescription = ?, content = ?, categoryid = ?,");
		sql.append(" createddate = ?, createdby = ?, modifieddate = ?, modifiedby = ? WHERE id = ?");
		update(sql.toString(), updateNew.getTitle(), updateNew.getThumbnail(), updateNew.getShortdescription(),
				updateNew.getContent(), updateNew.getCategoryId(), updateNew.getCreateddate(), 
				updateNew.getCreatedby(), updateNew.getModifieddate(), 
				updateNew.getModifiedby(), updateNew.getId());
	}

	@Override
	public void delete(long id) {
			String sql = "delete from  news where id=?";
			update(sql, id );
	}

	@Override
	public List<newsModel> findAll(Pageble pageble) {
	    StringBuilder sql = new StringBuilder("SELECT * FROM news");

	    if ( pageble.getSorter()!=null && StringUtils.isNotBlank(pageble.getSorter().getSortName()) &&StringUtils.isNotBlank(pageble.getSorter().getSortBy()) ) {
	        sql.append(" ORDER BY ").append(pageble.getSorter().getSortName()).append(" ").append(pageble.getSorter().getSortBy());
	    }

	    if (pageble.getOffset() !=null && pageble.getLimit()!=null) {
	        sql.append(" LIMIT ").append(pageble.getOffset()).append(",").append(pageble.getLimit());
	    }

	    return query(sql.toString(), new NewMapper());
	}
	
	@Override
	public List<newsModel> findAll() {
	    StringBuilder sql = new StringBuilder("SELECT * FROM news");

	    return query(sql.toString(), new NewMapper());
	}
	


	@Override
	public int getToltalItem() {
		String sql ="select count(*) from news"; 
		return count(sql);
	}



	}

