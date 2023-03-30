package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
            for (PurchaseList purchaseList : studentIdList) {
                int coursesId = session.createQuery("From Course where name = '" + purchaseList.getCourse() + "'", Course.class).getSingleResult().getId();
                int studentsId = session.createQuery("From Student where name ='" + purchaseList.getStudent() + "'", Student.class).getSingleResult().getId();
                LinkedPurchaseList list = new LinkedPurchaseList();
                list.setId(new LinkedPurchaseListKey(coursesId, studentsId));
                session.persist(list);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction().getStatus() == TransactionStatus.ACTIVE
                    || session.getTransaction().getStatus() == TransactionStatus.MARKED_ROLLBACK) {
                session.getTransaction().rollback();
            }
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}