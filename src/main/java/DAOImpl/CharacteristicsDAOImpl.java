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
import pojo.Characteristics;
import DAO.CharacteristicsDAO;

/**
 *
 * @author vali
 */
public class CharacteristicsDAOImpl implements CharacteristicsDAO{

    public void addCharacteristics(Characteristics medic) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(medic);
        transaction.commit();
        session.close();
    }

    public List<Characteristics> returnCharacteristics() {
        List<Characteristics> listaMedici = new ArrayList();
        Session session = HibernateUtil.getSessionFactory().openSession();
        org.hibernate.Query query = session.createQuery("From Characteristics");
        listaMedici = query.list();
        return listaMedici;
    }

    public void modifyCharacteristics(int idmedic, String nume, String prenume, String sectie, String Kingdom) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Characteristics detaliimedici = (Characteristics) session.load(Characteristics.class, idmedic);
        detaliimedici.setClas(nume);
        detaliimedici.setOrders(prenume);
        detaliimedici.setSpecies(sectie);
        detaliimedici.setKingdom(Kingdom);
        session.update(detaliimedici);
        transaction.commit();
        session.close();
    }

    public void deleteCharacteristics(Characteristics medic) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(medic);
        transaction.commit();
        session.close();
    }
}
