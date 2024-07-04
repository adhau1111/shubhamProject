package com.tka.ProjectDemo.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tka.ProjectDemo.entity.Country;
import com.tka.ProjectDemo.entity.Employee;
import com.tka.ProjectDemo.entity.User;
import com.tka.ProjectDemo.service.MainService;
@CrossOrigin
@RestController
@RequestMapping("/api")
public class MainController {
	@Autowired
	MainService service;
	
	@PostMapping("/addcountry")
	public String addCountry(@RequestBody Country c) {
		
		String msg=service.addCountry(c);
		
		return msg;
		
		
	}
	@PutMapping("/updateApi")
	public String UpdateCountry(@RequestBody Country c) {
		
		String msg=service.UpdateCountry(c);
		return msg;
		
		
	}
	@DeleteMapping("/deleteapi/{id}")
	public String DeleteCountry(@PathVariable int id) {
		
	String msg=	service.DeleteCountry(id);
	return msg;
		
	}
	@GetMapping("/getRecordById/{id}")
	public Country GetPerticularCountryById(@PathVariable int id) {
		
		Country cou=service.GetPerticularCountryById(id);
		
		return cou;
		
	}
	@GetMapping("/getAllCdata")
	public List<Country> GetAllCountryData() {
		
	List<Country> list=	service.GetAllCountryData();
	
	return list;
		
	}
	
	@PostMapping("/addEmpData")
	public String addEmployee(@RequestBody Employee e) {
		
		String msg=service.addEmployee(e);
		
		return msg;
		
		
	}
	
	@PutMapping("/UpdateApi")
	public String UpdateeEmpData(@RequestBody Employee e) {
		
		String msg=service.UpdateeEmpData(e);
		
		return msg;
		
		
	}
	@DeleteMapping("/deleteEmpApi/{id}")
	public String DeleteEmpData(@PathVariable int id) {
		
	String msg=	service.DeleteEmpData(id);
	return msg;
		
		
		
	}
	
	@GetMapping("/getEmpDataById/{id}")
	public Employee GetEmployeeDataById(@PathVariable int id) {
		
		Employee emp=service.GetEmployeeDataById(id);
		
		return emp;
		
		
	}
	@GetMapping("/GetAllEmpPerticularApi")
	public List<Employee> GetPerticularEmpRecord() {
		
		List<Employee>list= service.GetPerticularEmpRecord();	
		
		return list;
	}
	
	@GetMapping("/getEmpByStatus/{status}")
	public List<Employee> GetAllEmpByStatus(@PathVariable String status) {
		
		
		List<Employee>list=service.GetAllEmpByStatus(status);
		return list;
		
		
		
	}
	@PostMapping("/LoginApi")
      public HashMap checkUser(@RequestBody Employee emp) {
		
		HashMap map= service.checkUser(emp);
		return map;
	}
	@PostMapping("/loginuser")
	public HashMap loginUser(@RequestBody User user) {
		
		HashMap map= service.loginUser(user);
		return map;
		
	}}
