/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Autorizacao;
import Utils.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author VicNic
 */
public class AutorizacaoDaoImp implements AutorizacaoDao {
    @Override
    public void save(Autorizacao autorizacao) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(autorizacao);
        t.commit();
    }
    @Override
    public Autorizacao getAutorizacao(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return (Autorizacao) session.load(Autorizacao.class, id);
    }
    @Override
    public List<Autorizacao> list() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        List lista = session.createQuery("from Autorizacao").list();
        t.commit();
        return lista;
    }
    @Override
    public void remove(Autorizacao autorizacao) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(autorizacao);
        t.commit();
    }
    @Override
    public void update(Autorizacao autorizacao) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.update(autorizacao);
        t.commit();
    }
}
