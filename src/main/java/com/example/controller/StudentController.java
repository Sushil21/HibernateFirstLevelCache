package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.StudentDao;

@RestController
public class StudentController {
	
	@Autowired
	StudentDao studentDao;
	
	@RequestMapping(value="/getStudent",method=RequestMethod.GET)
	public @ResponseBody String getStudent(){
		System.out.println("inside");
		studentDao.getStudent(1);
		return "done";
}
}
