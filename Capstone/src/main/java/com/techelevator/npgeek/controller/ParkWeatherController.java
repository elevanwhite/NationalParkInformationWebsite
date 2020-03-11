package com.techelevator.npgeek.controller;



import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.npgeek.model.Park;
import com.techelevator.npgeek.model.ParkDao;
import com.techelevator.npgeek.model.Weather;

@Controller
public class ParkWeatherController {
	
	@Autowired
	private ParkDao parkDao;
	
	@GetMapping("/")
	public String displayHomePage(ModelMap modelMap) {
		List<Park> allParks = parkDao.getAllParks();
		modelMap.put("parks", allParks);
		return "home";
	}
	
	@GetMapping("/detail")
	public String displayDetailPage(@RequestParam String code, @RequestParam(required = false) String celsius, ModelMap modelMap, HttpSession session) {
		Park park = parkDao.getParkByCode(code);
		List<Weather> parkWeather= parkDao.getAllWeatherByPark(code);
		modelMap.put("park", park);
		
		if (celsius !=null) {
			session.setAttribute("celsius", celsius);
			if (celsius.equals("t")) {
				for (Weather w: parkWeather) {
					w.convertToCelsius();
				}
			
			}
		} else {
			try {
				if (session.getAttribute("celsius").equals("t")) {
					for (Weather w: parkWeather) {
						w.convertToCelsius();
					}
				}
			} catch (NullPointerException e) {
				// Catch NullPointer
			}
		}
		modelMap.put("weathers", parkWeather);
		return "detail";
	}
	
}
