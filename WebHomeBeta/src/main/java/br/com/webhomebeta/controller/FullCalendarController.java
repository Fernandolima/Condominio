package br.com.webhomebeta.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FullCalendarController {
	
	@RequestMapping(value = "home/calendar", method = RequestMethod.GET)
	public ModelAndView showCalendar(){
		return new ModelAndView("calendar");
	}
	
	
}
