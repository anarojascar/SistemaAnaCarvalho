/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.AacClientes;
import bean.AacFuncionarios;
import bean.AacVendas;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author anale
 */
public class VendasDAO extends AbstractDAO{
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
       Criteria criteria = session.createCriteria(AacVendas.class);
       criteria.add(Restrictions.eq("aac_id_vendas", codigo));
       List lista = criteria.list();
       session.getTransaction().commit();
       return lista;
    }
    
     public Object listCliente(AacClientes aacClientes) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(AacVendas.class);
        criteria.add(Restrictions.like("aacClientes", "%"+aacClientes+"%"));
        List lista = criteria.list();
        session.getTransaction().commit();        
        return lista;
    } 
     
     public Object listFuncionario(AacFuncionarios aacFuncionarios) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(AacVendas.class);
        criteria.add(Restrictions.like("aacFuncionarios", "%"+aacFuncionarios+"%"));
        List lista = criteria.list();
        session.getTransaction().commit();        
        return lista;
    } 
    
     public Object listClientesFuncionarios(AacClientes aacClientes, AacFuncionarios aacFuncionarios) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(AacVendas.class);
        criteria.add(Restrictions.like("aacClientes", "%"+aacClientes+"%"));
        criteria.add(Restrictions.like("aacFuncionarios", "%"+aacFuncionarios+"%"));
        List lista = criteria.list();
        session.getTransaction().commit();        
        return lista;
  }
     
    @Override
    public Object listAll() {
       session.beginTransaction();
       Criteria criteria = session.createCriteria(AacVendas.class);
       List lista = criteria.list();
       session.getTransaction().commit();
       return lista;
    }
    
    public static void main(String[] args){
        VendasDAO vendasDAO = new VendasDAO();
        vendasDAO.listAll();
        
    }
    
}
