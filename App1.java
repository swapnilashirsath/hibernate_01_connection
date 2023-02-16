package com.itp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App1 {

	public static void main(String[] args) {
 
		Configuration configuration;
		configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		
		SessionFactory sessionfactory;
		sessionfactory= configuration.buildSessionFactory(); // it help to create your connection actually
		
		 System.out.println("connected.." + sessionfactory);
		 System.out.println("system now connected :) ");
		 
		 Session session  = sessionfactory.openSession();    // Afrer that we can start  your  transaction query
		 System.out.println(" now Db session opened" + sessionfactory);
		 
		 Employee emp;
		 emp = new Employee (20,"Rohit_Patil",70000.55);
		 
		 Transaction transaction= session.beginTransaction();   // this class help to start your querry
		 
		 
		 session.save(emp);    // but hibernate can't understad what is emp object that's why you need to create one more xml file. that is employee.hbm.xml
		
		 System.out.println("save database.!");
		 
	// if you want to see  querry in console then ..
		 
		   session.get(Employee.class, 11);
		   System.out.println( session.get(Employee.class, 11));
		   //session.update(emp);
		 
 // if yot wnt to delete a querry the..   1st check whether this querry is exist Or not in console Or database!
		 
		// session.get(Employee.class, 9);
		// session.delete(session.get(Employee.class, 9));
		// System.out.println("now.. one query han been deleted from database.");
		 
// if you want to see all data inside a table then...
		List<Employee> emplist = session.createQuery( "from Employee").getResultList();
	    for (Employee employee : emplist) {
			System.out.println(employee);
		}
		 transaction.commit();   // here close your querry!
		 
		 session.close();
		 sessionfactory.close();
	}

}
