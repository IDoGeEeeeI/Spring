package com.flamexander.hibernate.h2;

import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class ProductDaoImpl implements ProductDao {
    private SessionFactoryUtils sessionFactoryUtils;

    public ProductDaoImpl(SessionFactoryUtils sessionFactoryUtils) {
        this.sessionFactoryUtils = sessionFactoryUtils;
    }

    @Override
    public product findById(Long id) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            product product = session.get(product.class, id);
            session.getTransaction().commit();
            return product;
        }
    }

    @Override
    public product findByTitle(String title) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            product product = session
                    .createQuery("select products from product products where product .title = :title", product.class)
                    .setParameter("title", title)
                    .getSingleResult();
            session.getTransaction().commit();
            return product;
        }
    }

    @Override
    public List<product> findAll() {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            List<product> products = session.createQuery("select u from product u").getResultList();
            session.getTransaction().commit();
            return products;
        }
    }

    @Override
    public void deleteById(Long id) {//я не уверен
        try (Session session = sessionFactoryUtils.getSession()){
            session.beginTransaction();
            Query query = session
                    .createQuery("delete from product products where products.id=:id");
            query.executeUpdate();
            session.getTransaction().commit();
        }
    }

    @Override
    public void save(product product) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            session.saveOrUpdate(product);
            session.getTransaction().commit();
        }
    }

    @Override
    public void testCaching() {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            session.get(product.class, 1L);
            session.get(product.class, 1L);
            session.get(product.class, 1L);
            session.getTransaction().commit();
        }
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            session.get(product.class, 1L);
            session.get(product.class, 1L);
            session.get(product.class, 1L);
            session.getTransaction().commit();
        }
    }
}
