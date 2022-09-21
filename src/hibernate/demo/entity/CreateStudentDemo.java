package hibernate.demo.entity;

import org.hibernate.*;
import org.hibernate.boot.spi.SessionFactoryOptions;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.spi.FilterDefinition;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.metadata.CollectionMetadata;
import org.hibernate.stat.Statistics;

import javax.naming.NamingException;
import javax.naming.Reference;
import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceUnitUtil;
import javax.persistence.SynchronizationType;
import javax.persistence.criteria.CriteriaBuilder;
import java.sql.Connection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CreateStudentDemo {
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
                    new Student("mehrnoosh", "rigi", "mehrnoosh.rigi@gmail.com");

            session.beginTransaction();
            session.save(tempStudent);
            session.getTransaction().commit();
        }finally {
            factory.close();
        }
    }
}
