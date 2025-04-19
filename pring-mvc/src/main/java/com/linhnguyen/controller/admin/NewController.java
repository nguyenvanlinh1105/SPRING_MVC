package com.linhnguyen.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller(value="NewControllerOfAdmin")
public class NewController {
	@RequestMapping(value="/new/list", method = RequestMethod.GET)
	public ModelAndView ShowNewList() {
		ModelAndView mav = new ModelAndView("admin/new/list");
		return mav;
	}
	@RequestMapping(value="/new/edit", method = RequestMethod.GET)
	public ModelAndView NewEdit() {
		ModelAndView mav = new ModelAndView("admin/new/edit");
		return mav;
	}
	
}
