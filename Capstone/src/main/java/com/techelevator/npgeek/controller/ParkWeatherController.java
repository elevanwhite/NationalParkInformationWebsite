package com.techelevator.npgeek.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.npgeek.model.Park;
import com.techelevator.npgeek.model.ParkDao;

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
	public String displayDetailPage(@RequestParam String code, ModelMap modelMap) {
		Park park = parkDao.getParkByCode(code);
		modelMap.put("park", park);
		return "detail";
	}
	
}
