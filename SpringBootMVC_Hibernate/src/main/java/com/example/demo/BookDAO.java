package com.example.demo;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class BookDAO {

    public void save(Book book) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(book);
        tx.commit();
        session.close();
    }

    public List<Book> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Book> list = session.createQuery("from Book", Book.class).list();
        session.close();
        return list;
    }

    public Book findById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Book book = session.get(Book.class, id);
        session.close();
        return book;
    }
}
