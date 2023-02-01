/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOImpl;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.Animals;
import DAO.AnimalsDAO;

/**
 *
 * @author vali
 */
public class AnimalsDAOImpl implements AnimalsDAO{

    public void addAnimals(Animals pacient) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(pacient);
        transaction.commit();
        session.close();
    }

    public List<Animals> returnAnimals() {
        List<Animals> listaPacienti = new ArrayList();
        Session session = HibernateUtil.getSessionFactory().openSession();
        org.hibernate.Query query = session.createQuery("From Animals");
        listaPacienti = query.list();
        return listaPacienti;
    }

    public void modifyAnimals(int idpacient, String nume, String prenume) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Animals detaliipacienti = (Animals) session.load(Animals.class, idpacient);
        detaliipacienti.setName(nume);
        detaliipacienti.setRegion(prenume);
        session.update(detaliipacienti);
        transaction.commit();
        session.close();
    }

    public void deleteAnimals(Animals pacient) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(pacient);
        transaction.commit();
        session.close();
    }
}
