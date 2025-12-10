/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.AacClientes;
import bean.AacFuncionarios;
import bean.AacVendas;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author anale
 */
public class VendasDAO extends AbstractDAO {

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

    public List listDataVenda(Date aacDataVenda) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(AacVendas.class); 
        criteria.add(Restrictions.ge("aacDataVenda", aacDataVenda)); 
        List lista = criteria.list(); session.getTransaction().commit(); 
        return lista;
    }  
    public Object listValorTotal(double aacValorTotal) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(AacVendas.class);
        criteria.add(Restrictions.ge("aacValorTotal", aacValorTotal));
        List lista = criteria.list();
        session.getTransaction().commit();        
        return lista;
    }
    
    public Object listDataValor(Date aacDataVenda, double aacValorTotal) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(AacVendas.class);
        criteria.add(Restrictions.ge("aacDataVenda", aacDataVenda));
        criteria.add(Restrictions.ge("aacValorTotal", aacValorTotal));
        List lista = criteria.list();
        session.getTransaction().commit();        
        return lista;
  }
    
        @Override
        public Object listAll
        
            () {
       session.beginTransaction();
            Criteria criteria = session.createCriteria(AacVendas.class);
            List lista = criteria.list();
            session.getTransaction().commit();
            return lista;
        }
    
    

    public static void main(String[] args) {
        VendasDAO vendasDAO = new VendasDAO();
        vendasDAO.listAll();

    }

}
