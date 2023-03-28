package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().
                configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();

            List<PurchaseList> studentIdList = session.createQuery("From PurchaseList", PurchaseList.class).getResultList();
            List<Course> coursesList = session.createQuery("From Course", Course.class).getResultList();
            List<Student> studentsList = session.createQuery("From Student", Student.class).getResultList();

            for (PurchaseList purchaseList : studentIdList) {
                for (Course course : coursesList) {
                    if (purchaseList.getCourse().equals(course.getName())) {
                        for (Student student : studentsList) {
                            if (purchaseList.getStudent().equals((student.getName()))) {
                                LinkedPurchaseList list = new LinkedPurchaseList();
                                list.setId(new LinkedPurchaseListKey(course.getId(), student.getId()));
                                session.persist(list);
                            }
                        }
                    }
                }
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction().getStatus() == TransactionStatus.ACTIVE
                    || session.getTransaction().getStatus() == TransactionStatus.MARKED_ROLLBACK) {
                session.getTransaction().rollback();
            }
        } finally {
            sessionFactory.close();
        }

    }
}