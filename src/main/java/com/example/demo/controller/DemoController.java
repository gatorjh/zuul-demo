package com.example.demo.controller;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/restservices")
@Api(value = "/zuul-demo", tags = { "restservices" }, produces = "application/json")
public class DemoController {
	@Autowired
	Environment env;
	
	@RequestMapping(value = {"/version" }, method = RequestMethod.GET)
	@ResponseBody
	public Object  getVersion() {
		 return Collections.singletonMap("version", env.getProperty("info.app.name") + " " + env.getProperty("info.version"));
	}
}