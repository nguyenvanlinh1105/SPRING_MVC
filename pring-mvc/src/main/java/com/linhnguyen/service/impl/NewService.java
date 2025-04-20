package com.linhnguyen.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.linhnguyen.dao.INewDAO;
import com.linhnguyen.model.newsModel;
import com.linhnguyen.service.INewService;
@Service
public class NewService implements INewService{

	@Autowired
	private INewDAO NewDao;

	
	@Override
	public List<newsModel> findAll( ) {
		return NewDao.findAll();
	}


}
