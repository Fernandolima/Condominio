package br.com.webhomebeta.controller;

import java.util.ArrayList;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.webhomebeta.json.CalendarEventJSON;
import br.com.webhomebeta.service.CalendarEventService;

@Controller
public class FullCalendarController {

	@Autowired
	private CalendarEventService calendarEventService;
	
	@RequestMapping(value = "home/calendar", method = RequestMethod.GET)
	public ModelAndView showCalendar() {
		return new ModelAndView("calendar");
	}

	@RequestMapping(value = "event", method = { RequestMethod.POST,
			RequestMethod.GET })
	public @ResponseBody
	List<CalendarEventJSON> feedCalender(HttpServletRequest request) {

		System.out.println(request.getMethod());
		if (request.getMethod() == "POST") {
			
		} else {

			DateTime dt = new DateTime(2013, 11, 6, 12, 0);
			DateTime dtEnd = new DateTime(2013, 11, 8, 12, 0);

			List<CalendarEventJSON> calendarEventJSONs = new ArrayList<>();
			CalendarEventJSON c = new CalendarEventJSON();
			c.setEditable(true);
			c.setStart(dt.toString(DateTimeFormat
					.forPattern("yyyy-MM-dd'T'HH:mm:ss'Z")));
			c.setEnd(dtEnd.toString(DateTimeFormat
					.forPattern("yyyy-MM-dd'T'HH:mm:ss'Z")));
			c.setTitle("Meu evento");
			c.setId(1);
			calendarEventJSONs.add(c);

			System.out.println(dt.toString(DateTimeFormat
					.forPattern("yyyy-MM-dd'T'HH:mm:ss'Z")));
			return calendarEventJSONs;

		}

		return null;
	}

}
