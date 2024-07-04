package com.tka.ProjectDemo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.ProjectDemo.dao.MainDao;
import com.tka.ProjectDemo.entity.Country;
import com.tka.ProjectDemo.entity.Employee;
import com.tka.ProjectDemo.entity.User;

@Service
public class MainService {
	@Autowired
	MainDao dao;

	public String addCountry(Country c) {
		
		String msg=dao.addCountry(c);
		
		if(Objects.isNull(msg)) {
			
			msg="Data is not Added..";
			
		}
		
		return msg;
	}

	public String UpdateCountry(Country c) {
		String msg=dao.UpdateCountry(c);
		
		if(Objects.isNull(msg)) {
			
			msg="Data is not Updated...";
			
		}
		return msg;
	}

	public String DeleteCountry(int id) {
	String msg=dao.DeleteCountry(id);
	
	if(Objects.isNull(msg)) {
		
		msg="Record is deleted........";
		
		
	}
	
		return msg;
	}
	
	public Country GetPerticularCountryById(int id) {
		
		Country cou= dao.GetPerticularCountryById(id);
		
		if(Objects.isNull(cou)) {
			cou=null;
			
		}
		
		return cou;
		
	}

	public List<Country> GetAllCountryData() {
	List<Country>list=dao.GetAllCountryData();
	
	if(Objects.isNull(list)) {
		list=null;
		
	}
		return list;
	}

	public String addEmployee(Employee e) {
		
		String msg=dao.addEmployee(e);
		
		if(Objects.isNull(msg)) {
			msg="Employee Data is not Added.......";
		}
		
		
		return msg;
	}

	public String UpdateeEmpData(Employee e) {
		
		String msg=dao.UpdateeEmpData(e);
		
		if(Objects.isNull(msg)) {
			
			msg="Record is Not Updated..";
			
		}
		
		return msg;
	}

	public String DeleteEmpData(int id) {
		
		String msg=dao.DeleteEmpData(id);
		
		if(Objects.isNull(msg)) {
			
			msg="Record is not deleted.....";
		}
		return msg;
	}

	public Employee GetEmployeeDataById(int id) {
		
		Employee emp= dao.GetEmployeeDataById(id);
		
		if(Objects.isNull(emp)) {
			
			emp=null;
			
		}
		return emp;
	}

	public List<Employee> GetPerticularEmpRecord() {
	List<Employee>list=	dao.GetPerticularEmpRecord();
	
	if(Objects.isNull(list)) {
		
		list=null;
		
	}
		return list;
	}

	public List<Employee> GetAllEmpByStatus(String status) {
		
	List<Employee>list=	dao.GetAllEmpByStatus(status);
	    
	if(Objects.isNull(list)) {
		list=null;
		
	}
		
		return list;
	}

      public HashMap checkUser(Employee emp) {
		
		Employee Emp= dao.checkUser(emp);
		HashMap map=new HashMap();
		if(Objects.isNull(Emp)) {
			map.put("msg","Invalid User");
			map.put("user", Emp);
		}else {
			map.put("msg","Valid User");
			map.put("user", Emp);
	}
		
		
		return map;
		
	

}

	public HashMap loginUser(User user) {
		User e= dao.loginUser(user);
		HashMap map=new HashMap();
		if(Objects.isNull(e)) {
			map.put("msg","Invalid User");
			map.put("user", e);
		}else {
			map.put("msg","Valid User");
			map.put("user", e);
	}
		
		
		return map;
      
      
}
}

