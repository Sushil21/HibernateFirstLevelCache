# HibernateFirstLevelCache
HibernateFirstLevelCache


how to run:
1. create a schema hibernateCache in mysql
2. add project to tomcat and start.
3. student table will create automatically in hibernateCache.
4. insert a record with id 1.
5. execute below url 

http://localhost:8080/HibernateCache/getStudent


output on console:

Hibernate: select student0_.ID as ID1_0_0_, student0_.STUDENT_NAME as STUDENT_2_0_0_ from STUDENT student0_ where student0_.ID=?

first query result student is::Student [id=1, studentName=sushil]
second query result student is::Student [id=1, studentName=sushil]

As you see in below code of call StudentDaoImpl, 
i tried to get same record of student with same id so hibernate firstlevel cache automatically work at here, 
you can see above output the query execute single time in a session and we get same output.

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
