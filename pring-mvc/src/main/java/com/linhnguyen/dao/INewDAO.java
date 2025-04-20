package com.linhnguyen.dao;

import java.util.List;

import com.linhnguyen.model.newsModel;
import com.linhnguyen.paging.Pageble;

public interface INewDAO extends GenericDAO<newsModel>{
	newsModel findOne(Long id);
	List<newsModel> findByCategoryId(Long categoryId);
	// theem moi trar ve id -long
	Long save (newsModel newModel);
	void update (newsModel updateNew);
	void delete( long id);
	List<newsModel> findAll(Pageble pageble);
	List<newsModel> findAll();
	int getToltalItem ();
	
}
