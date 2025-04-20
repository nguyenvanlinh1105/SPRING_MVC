package com.linhnguyen.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.linhnguyen.model.newsModel;
import com.linhnguyen.service.INewService;

@Controller(value="NewControllerOfAdmin")
public class NewController {
	
	@Autowired 
	private INewService newservice;
	
	@RequestMapping(value="admin/new/list", method = RequestMethod.GET)
	public ModelAndView ShowNewList(@ModelAttribute("model") newsModel model) {
		ModelAndView mav = new ModelAndView("admin/new/list");
		model.setListResult(newservice.findAll());
		mav.addObject("model", model);
		return mav;
	}
	@RequestMapping(value="admin/new/edit", method = RequestMethod.GET)
	public ModelAndView NewEdit() {
		ModelAndView mav = new ModelAndView("admin/new/edit");
		return mav;
	}
	
}
