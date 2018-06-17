package com.example.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.dao.StudentDao;
import com.example.model.Student;

@Component
public class StudentDaoImpl implements StudentDao{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public Student getStudent(long id) {
		 
		Session session=sessionFactory.openSession();
		try{
			 Student stud = session.get(Student.class, id);
			 System.out.println("first query result student is::"+stud);
			 Student stud2 = session.get(Student.class, id);
			 System.out.println("second query result student is::"+stud2);
			 return stud;
		}catch(Exception e){
			System.out.println(e);
			 
		}finally{
			if(null!=session && session.isOpen()){
				session.close();
			}
}
		return null;
	}

}
