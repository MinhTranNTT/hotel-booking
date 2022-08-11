package com.hotel.admin.user;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class TestAjax {
	
	@GetMapping
	public String getxyz(Map<String, Object> models, 
            @RequestParam(required = false) String endDate,
            @RequestParam(required = false) String startDate,
            @RequestParam(required = false, defaultValue = "5") Integer limit) {
		
		return "/xyz/page";
	}
}
