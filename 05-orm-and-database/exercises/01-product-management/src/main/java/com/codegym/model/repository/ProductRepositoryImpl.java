package com.codegym.model.repository;

import com.codegym.model.bean.Product;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    @Override
    public List<Product> getAll() {
        List<Product> list = null;
        String hql = "FROM product";
        Session session = null;
        try {
            session = BaseRepository.sessionFactory.openSession();
            list = session.createQuery(hql, Product.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return list;
    }

    @Override
    public Product getById(int id) {
        String hql = "FROM product p WHERE p.id = :id";
        Session session = null;
        Product product = null;
        try {
            session = BaseRepository.sessionFactory.openSession();
            TypedQuery<Product> query = session.createQuery(hql, Product.class);
            query.setParameter("id", id);
            product = query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return product;
    }

    @Override
    public void add(Product product) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = BaseRepository.sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(product);
            transaction.commit();
        } catch (
                Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public boolean update(Product product) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = BaseRepository.sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(product);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return false;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Product delete(int id) {
        Product product = null;
        Session session = null;
        Transaction transaction = null;
        try {
            session = BaseRepository.sessionFactory.openSession();
            transaction = session.beginTransaction();
            product = getById(id);
            session.remove(product);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return product;
    }

    @Override
    public List<Product> searchByName(String name) {
        Session session = null;
        List<Product> list = new ArrayList<>();
        String hql = "from product p where p.name like :name";
        try {
            session = BaseRepository.sessionFactory.openSession();
            TypedQuery<Product> query = session.createQuery(hql, Product.class);
            query.setParameter("name", "%" + name + "%");
            list = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return list;
    }
}
