package hibernate.demo.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {
    public static void main(String args[]){
        //  create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        // create session
        Session session = factory.getCurrentSession();
        try {

            session.beginTransaction();
            // query the student
            List<Student> theStudents = session.createQuery("from Student").list();
            for (Student tempStudent: theStudents){
                System.out.println("student: "+tempStudent);
            }

            theStudents = session.createQuery("from Student s where s.lastName = 'rigi'").list();
            for (Student tempStudent: theStudents){
                System.out.println("student: "+tempStudent);
            }
            session.getTransaction().commit();
        }finally {
            factory.close();
        }
    }
}
