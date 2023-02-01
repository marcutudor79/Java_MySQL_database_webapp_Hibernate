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
import pojo.Junction;
import DAO.JunctionDAO;
import pojo.Animals;
import pojo.Characteristics;

/**
 *
 * @author vali
 */
public class JunctionDAOImpl implements JunctionDAO{

    public void addJunction(Junction consultatie) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(consultatie);
        transaction.commit();
        session.close();
    }

    public List<Junction> returnJunction() {
        List<Junction> listaConsultatie = new ArrayList();
        Session session = HibernateUtil.getSessionFactory().openSession();
        org.hibernate.Query query = session.createQuery("From Junction");
        listaConsultatie = query.list();
        return listaConsultatie;
    }

    public void modifyJunction(Integer idconsultatie, Animals pacient, Characteristics medic) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Junction detaliiconsultatiei;
        detaliiconsultatiei = (Junction) session.load(Junction.class, idconsultatie);
        detaliiconsultatiei.setAnimals(pacient);
        detaliiconsultatiei.setCharacteristics(medic);
        session.update(detaliiconsultatiei);
        transaction.commit();
        session.close();
    }

    public void deleteJunction(Junction consultatie) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(consultatie);
        transaction.commit();
        session.close();
    }
}
