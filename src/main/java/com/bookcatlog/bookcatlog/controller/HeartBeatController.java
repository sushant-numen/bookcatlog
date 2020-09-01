package com.bookcatlog.bookcatlog.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HeartBeatController {

	@GetMapping("/hearbeatcontroller")
	public Map<String ,String>heartbeat(){
		 Map<String, String> newMap = new HashMap<>();
	        newMap.put("status", "bookcatlog is ready and live");
	        return newMap;
	}
}
