package hibernate.demo.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {
    public static void main(String args[]){
        //  create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        // create session
        Session session = factory.getCurrentSession();
        try {
            // create 3 student objects
            Student tempStudent1 =
                    new Student("s1", "rigi", "s1@gmail.com");
            Student tempStudent2 =
                    new Student("s2", "rigi", "s2@gmail.com");
            Student tempStudent3 =
                    new Student("s3", "rigi", "s3@gmail.com");

            session.beginTransaction();
            session.save(tempStudent1);
            session.save(tempStudent2);
            session.save(tempStudent3);
            session.getTransaction().commit();
        }finally {
            factory.close();
        }
    }
}
