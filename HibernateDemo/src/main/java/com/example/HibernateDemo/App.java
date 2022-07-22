package com.example.HibernateDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


public class App 
{
    public static void main( String[] args )
    {
		/*
		 * Laptop l1 = new Laptop(); l1.setLaptopId("001"); l1.setLaptopCompany("dell");
		 * Laptop l2 = new Laptop(); l2.setLaptopId("002");
		 * l2.setLaptopCompany("lenovo");
		 * 
		 * Student s1 = new Student(); s1.setStudentId("101");
		 * s1.setStudentName("revathi"); s1.setMarks("80"); s1.getLaptop().add(l1);
		 * s1.getLaptop().add(l2);
		 * 
		 * Student s2 = new Student(); s2.setStudentId("102");
		 * s2.setStudentName("Naveen"); s2.setMarks("60"); s2.getLaptop().add(l1);
		 * s2.getLaptop().add(l2);
		 * 
		 * l1.getStudent().add(s1); l2.getStudent().add(s1); l1.getStudent().add(s2);
		 * l2.getStudent().add(s2);
		 */        
		/*
		 * EmployeeName name = new EmployeeName(); name.setFirstName("vegi");
		 * name.setLastName("revathi"); name.setMiddleName("");
		 */
    	//Employee e = new Employee();
		/*
		 * e.setEmployeeId("101"); e.setEmployeeName(name); e.setSalary(100000);
		 */
    	
        Configuration config = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class).addAnnotatedClass(Employee.class);
        
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
        SessionFactory sf = config.buildSessionFactory(reg); 
        Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		/*
		 * session.save(s1); session.save(s2); session.save(l1); session.save(l2);
		 */
		Employee e = (Employee)session.get(Employee.class, "101");
		System.out.println(e.toString());
		tx.commit();
		session.close();
		
		Session session2 = sf.openSession();
		Transaction tx1 = session2.beginTransaction();
		/*
		 * session.save(s1); session.save(s2); session.save(l1); session.save(l2);
		 */
		Employee e1 = (Employee)session2.get(Employee.class, "101");
		System.out.println(e1.toString());
		tx1.commit();
		session2.close();
		
    }
}
