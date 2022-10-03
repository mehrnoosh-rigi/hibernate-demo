package hibernate.demo.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {
    public static void main(String args[]){
        //  create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        // create session
        Session session = factory.getCurrentSession();
        try {
            int id = 7;
            // Get new session and start transaction
            session = factory.getCurrentSession();
            session.beginTransaction();
            // retrieve student based on ID on primary key
            System.out.println("\n getting student with ID" + id);
            Student myStudent = session.get(Student.class, id);
            session.delete(myStudent);
            // commit the transaction
            session.getTransaction().commit();
        }finally {
            factory.close();
        }
    }
}
