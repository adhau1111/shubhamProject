package com.tka.ProjectDemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
//import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.tka.ProjectDemo.entity.Country;
import com.tka.ProjectDemo.entity.Employee;
import com.tka.ProjectDemo.entity.User;

@Repository
public class MainDao {

	@Autowired
	SessionFactory factory;
	
	
	public String addCountry(Country c) {
		
		
		Session session=null;
		Transaction tx=null;
		String msg=null;
		
		try {
		session=factory.openSession();
		tx=session.beginTransaction();
		session.persist(c);
		tx.commit();
		msg="Data Added succesfully..";
		
		}catch (Exception e) {
			
			if(tx!=null) {
				
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			
			if(session!=null) {
				
				session.close();
			}
		}
		
		
		
		
		return msg;
		
		
		
	}


	public String UpdateCountry(Country c) {
		Session session=null;
		Transaction tx=null;
		String msg=null;
		
		try {
			session=factory.openSession();
			tx=session.beginTransaction();
		    Country country=session.get(Country.class,c.getCid());
		    country.setCname(c.getCname());
		    
		    session.merge(country);
		    tx.commit();
		    
		    msg="Data is updated successfully";
			
		}catch (Exception e) {
			
			if(tx!=null) {
				
				tx.rollback();
				
			}
			e.printStackTrace();
		}finally {
			
			if(session!=null) {
				
				session.close();
				
			}
		}
		return msg;
	}


	public String DeleteCountry(int id) {
		Session session=null;
		Transaction tx=null;
		String msg=null;
		
		try {
			
			session=factory.openSession();
			tx=session.beginTransaction();
			
		Country country=session.get(Country.class,id);
		session.remove(country);
		
		tx.commit();
		msg="Record is Deleted sucessfully.... ";
			
		}catch (Exception e) {
			
			if(tx!=null) {
				tx.rollback();
				
			}
			
			e.printStackTrace();
		}finally {
			
			if(session!=null) {
				
				session.close();
			}
		}
		return msg;
		
	}


	public Country GetPerticularCountryById(int id) {
		Session session=null;
		Transaction tx=null;
		Country cou=null;
		String strquery="from Country where id=:myid";
		
		
		try {
			
			session=factory.openSession();
			tx=session.beginTransaction();
			
//		    Query<Country>query=session.createQuery(strquery,Country.class);
			
			 Query<Country>query=session.createQuery(strquery,Country.class);
		    
		    query.setParameter("myid", id);
		    cou=query.uniqueResult();
		    
		    tx.commit();
		    
		    
			
		}catch (Exception e) {
			if(tx!=null) {
				tx.rollback();
				
			}
			
			e.printStackTrace();
		}finally {
			
			if(session!=null) {
				
			 session.close();
			}
		}
		
		return cou;
	}


	public List<Country> GetAllCountryData() {
		Session session=null;
		Transaction tx=null;
		String strquery="from Country";
		List<Country>list=null;
		
		try {
			
			session=factory.openSession();
			tx=session.beginTransaction();
		    Query<Country>query=session.createQuery(strquery,Country.class);
		    
		    list= query.list();	
		    tx.commit();
			
		}catch (Exception e) {
			
			if(tx!=null) {
				tx.rollback();
				
			}
			
			e.printStackTrace();
		}finally {
			
			if(session!=null) {
				session.close();
				
			}
		}
		return list;
	}


	public String addEmployee(Employee e) {
		
	 Session session=null;
	 Transaction tx=null;
	 
	  String msg=null;
	  
	  try {
		  
		  session=factory.openSession();
		  tx=session.beginTransaction();
		  session.persist(e);
		  
		  tx.commit();
		  msg="Employee Data is Added Perfectly.....";
		  
	  }catch (Exception e1) {
		  
		  if(tx!=null) {
			  tx.rollback();
			  
		  }
		
		  e1.printStackTrace();
	}finally {
		
		if(session!=null) {
			
			session.close();
			
		}
		
	}
	 
		
		return msg;
	}


	public String UpdateeEmpData(Employee e) {
       Session session=null;
       Transaction tx=null;
       String msg=null;
       
       try {
    	   
    	   session=factory.openSession();
    	   tx=session.beginTransaction();
    	   
    	 Employee emp=  session.get(Employee.class, e.getId());
    	 
    	 emp.setName(e.getName());
		  emp.setPhoneno(e.getPhoneno());
		  emp.setCountry(e.getCountry());
		  emp.setCreatedby(e.getCreatedby());
		  emp.setCreateddtm(e.getCreateddtm());
		  emp.setDepartment(e.getDepartment());
		  emp.setStatus(e.getStatus());
		  emp.setUpdatedby(e.getUpdatedby());
		  emp.setUpdateddtm(e.getUpdateddtm());
		  
		  session.merge(emp);
		  tx.commit();
		  
		  msg="Employee data is Updated successfully..........";
    	   
    	   
    	   
       }catch (Exception e2) {
    	   
    	   if(tx!=null) {
    		   
    		   tx.rollback();
    		   
    	   }
		
    	   e2.printStackTrace();
	}finally {
		
		if(session!=null) {
			
			session.close();
		}
	}
		
		
		return msg;
	}


	public String DeleteEmpData(int id) {
		
		Session session=null;
		Transaction tx=null;
		String msg=null;
		
		try {
			
			 session=factory.openSession();
	    	   tx=session.beginTransaction();
	    	Employee emp=   session.get(Employee.class, id);
	    	
	    	session.remove(emp);
	    	tx.commit();
	    	msg="Record is deleted successfully..........";
			
		}catch (Exception e3) {
			
			if(tx!=null) {
				tx.rollback();
			}
			e3.printStackTrace();
		}finally {
			if(session!=null) {
				
				session.close();
				
			}
			
		}
		return msg;
	}


	public Employee GetEmployeeDataById(int id) {
		Session session=null;
		Transaction tx=null;
		Employee emp=null;
		String strquery="from Employee where id=:myid";
		
		
		
		
		try {
			
			session=factory.openSession();
			tx=session.beginTransaction();
	    	Query<Employee> query=session.createQuery(strquery,Employee.class);
	    	
	    	query.setParameter("myid", id);
	    	emp=query.uniqueResult();
	    	 
	    	
	    	tx.commit();
		}catch (Exception e4) {
			
			
			if(tx!=null) {
				tx.rollback();
			}
			
			
			e4.printStackTrace();
		}finally {
			
			if(session!=null) {
				session.close();
			}
		}
		return emp;
	}


	public List<Employee> GetPerticularEmpRecord() {
		
		Session session=null;
		Transaction tx=null;
		Employee emp=null;
		String strquery="from Employee";
		List<Employee>list=null;
		
		
		try {
			
			session=factory.openSession();
			tx=session.beginTransaction();
			
			Query<Employee>query= session.createQuery(strquery,Employee.class);
			
			list=query.list();
			
			tx.commit();
			
		}catch (Exception e5) {
			if(tx!=null) {
				tx.rollback();
			}
		
			e5.printStackTrace();
		}finally {
			
			if(session!=null) {
				session.close();
			}
		}
		
		
		
		return list;
	}


	public List<Employee> GetAllEmpByStatus(String status) {
		Session session=null;
		Transaction tx=null;
		
		String strQuery="from Employee where status=:mystatus";
		List<Employee>list=null;
		
		try {
			session=factory.openSession();
			tx=session.beginTransaction();
		    Query<Employee>	query=session.createQuery(strQuery,Employee.class);
	    	query.setParameter("mystatus", status);
	    	list=query.list();
		   tx.commit();
			
		}catch (Exception e6) {
			
			if(tx!=null) {
				
				tx.rollback();
			}
			e6.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		return list;
		
	}


public Employee checkUser(Employee emp) {
		
		Session session=null;
		Transaction tx=null;
		String strQuery="from Employee where name=:name and phoneno=:phoneno";
		Employee employee=null;
		try {		
			 session= factory.openSession();
			 tx=session.beginTransaction();
			 
			 Query<Employee> query= session.createQuery(strQuery,Employee.class);
			 
			 query.setParameter("name",emp.getName() );
			 query.setParameter("phoneno", emp.getPhoneno());
			 
			 employee= query.uniqueResult();
			 
			 tx.commit();
			 
		}catch (Exception e1) {
			if(tx!=null) {
				tx.rollback();
			}
						
			e1.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		
		return employee;
		
		
	}


public User loginUser(User user) {
	Session session=null;
	Transaction tx=null;
	String strQuery="from User where username=:username and password=:password";
	User u=null;
	try {		
		 session= factory.openSession();
		 tx=session.beginTransaction();
		 
		 Query<User> query= session.createQuery(strQuery,User.class);
		 
		 query.setParameter("username",user.getUsername() );
		 query.setParameter("password", user.getPassword());
		 
		 u= query.uniqueResult();
		 
		 tx.commit();
		 
	}catch (Exception e1) {
		if(tx!=null) {
			tx.rollback();
		}
					
		e1.printStackTrace();
	}finally {
		if(session!=null) {
			session.close();
		}
	}
	
	return u;
	
}

}
	


	
	


