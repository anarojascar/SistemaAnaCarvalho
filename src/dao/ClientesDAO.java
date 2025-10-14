
package dao;

import bean.AacClientes;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author anale
 */
public class ClientesDAO extends AbstractDAO{
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
       Criteria criteria = session.createCriteria(AacClientes.class);
       criteria.add(Restrictions.eq("", codigo));
       List lista = criteria.list();
       session.getTransaction().commit();
       return lista;
    }

    @Override
    public Object listAll() {
       session.beginTransaction();
       Criteria criteria = session.createCriteria(AacClientes.class);
       List lista = criteria.list();
       session.getTransaction().commit();
       return lista;
    }
    
    public static void main(String[] args){
        ClientesDAO clientesDAO = new ClientesDAO();
        clientesDAO.listAll();
        
    }
    
}
