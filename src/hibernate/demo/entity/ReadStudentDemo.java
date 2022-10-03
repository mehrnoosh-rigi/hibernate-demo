package hibernate.demo.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {
    public static void main(String args[]){
        //  create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        // create session
        Session session = factory.getCurrentSession();
        try {
            Student tempStudent =
                    new Student("s4", "rigi", "s4@gmail.com");

            session.beginTransaction();
            session.save(tempStudent);
            System.out.println(tempStudent.getId());
            session.getTransaction().commit();

            // new code:
            // Get new session and start transaction
            session = factory.getCurrentSession();
            session.beginTransaction();
            // retrieve student based on ID on primary key
            System.out.println("\n getting student with ID" + tempStudent.getId());
            Student myStudent = session.get(Student.class, tempStudent.getId());
            // commit the transaction
            session.getTransaction().commit();
        }finally {
            factory.close();
        }
    }
}
