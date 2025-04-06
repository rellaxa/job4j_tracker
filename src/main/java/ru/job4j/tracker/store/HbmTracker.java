package ru.job4j.tracker.store;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ru.job4j.tracker.Item;

import java.util.ArrayList;
import java.util.List;

public class HbmTracker implements Store, AutoCloseable {

    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure().build();

    private final SessionFactory sf = new MetadataSources(registry)
            .buildMetadata().buildSessionFactory();

    @Override
    public Item add(Item item) {
        try (Session session = sf.openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                session.save(item);
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
            }
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        boolean updated = false;
        try (Session session = sf.openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                updated = session.createQuery("update Item set name = :fName, created = :fCreated where id = :fId")
                        .setParameter("fName", item.getName())
                        .setParameter("fCreated", item.getCreated())
                        .setParameter("fId", id)
                        .executeUpdate() > 0;
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
            }
        }
        return updated;
    }

    @Override
    public void delete(int id) {
        try (Session session = sf.openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                session.createQuery("delete from Item where id = :fId")
                        .setParameter("fId", id)
                        .executeUpdate();
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
            }
        }
    }

    @Override
    public List<Item> findAll() {
        List<Item> items = new ArrayList<>();
        try (Session session = sf.openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                items = session.createQuery("from Item", Item.class).list();
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
            }
        }
        return items;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> items = new ArrayList<>();
        try (Session session = sf.openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                items = session.createQuery("from Item where name = :fName", Item.class)
                        .setParameter("fName", key)
                        .list();
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
            }
        }
        return items;
    }

    @Override
    public Item findById(int id) {
        try (Session session = sf.openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                Item item = session.createQuery("from Item where id = :fId", Item.class)
                        .setParameter("fId", id)
                        .uniqueResult();
                transaction.commit();
                return item;
            } catch (Exception e) {
                transaction.rollback();
            }
        }
        return null;
    }

    @Override
    public void close() {
        StandardServiceRegistryBuilder.destroy(registry);
    }
}