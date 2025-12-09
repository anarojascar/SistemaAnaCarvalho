/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.AacFuncionarios;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author anale
 */
public class FuncionariosDAO extends AbstractDAO{

    @Override
    public void insert(Object object) {
        session.beginTransaction();
        session.save(object);
        session.getTransaction().commit();
    }

    @Override
    public void update(Object object) {
        session.beginTransaction();
        session.flush();
        session.clear();
        session.update(object);
        session.getTransaction().commit();
    }

    @Override
    public void delete(Object object) {
        session.beginTransaction();
        session.flush();
        session.clear();
        session.delete(object);
        session.getTransaction().commit();
    }

    @Override
    public Object list(int codigo) {
       session.beginTransaction();
       Criteria criteria = session.createCriteria(AacFuncionarios.class);
       criteria.add(Restrictions.eq("", codigo));
       List lista = criteria.list();
       session.getTransaction().commit();
       return lista;
    }
    public Object listNome(String nome) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(AacFuncionarios.class);
        criteria.add(Restrictions.like("nome", "%"+nome+"%"));
        List lista = criteria.list();
        session.getTransaction().commit();        
        return lista;
    } 
     public Object listContrato(String contrato) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(AacFuncionarios.class);
        criteria.add(Restrictions.like("contrato", contrato+"%"));
        List lista = criteria.list();
        session.getTransaction().commit();        
        return lista;
    } 
      public Object listNomeContrato(String nome, String contrato) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(AacFuncionarios.class);
        criteria.add(Restrictions.like("nome", "%"+nome+"%"));
        criteria.add(Restrictions.like("contrato", contrato+"%"));
        List lista = criteria.list();
        session.getTransaction().commit();        
        return lista;
      }
        
    @Override
    public Object listAll() {
       session.beginTransaction();
       Criteria criteria = session.createCriteria(AacFuncionarios.class);
       List lista = criteria.list();
       session.getTransaction().commit();
       return lista;
    }
    
    public static void main(String[] args){
        FuncionariosDAO funcionariosDAO = new FuncionariosDAO();
        funcionariosDAO.listAll();
        
    }
    
}
