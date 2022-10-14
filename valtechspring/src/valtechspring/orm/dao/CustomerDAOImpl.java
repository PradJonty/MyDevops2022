package valtechspring.orm.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;


import valtechspring.orm.Customer;




public class CustomerDAOImpl implements CustomerDAO {
    
    
    @Override
    public List<Customer> getByTxAmountGreaterThan(Session session,float amount){
        Query q = session.createQuery("SELECT c FROM Customer c JOIN c.accounts a JOIN a.txts t where t.amount > ?");
        q.setFloat(0, amount);
        return q.list();
        
    }
    @Override
    public List<Customer> getByAccountBalanceGreaterThan(Session session,double balance) {
        Query q=session.createQuery("SELECT c FROM Customer  c JOIN c.accounts a WHERE a.balance > ?");
        q.setDouble(0, balance);
        return q.list();
    }
    @Override
    public List<Customer> getByState(Session session,String state){
        Query q = session.createQuery("SELECT c FROM Customer c WHERE c.address.state=?");
        q.setString(0,state);
        return q.list();
    }
    
    /* (non-Javadoc)
     * @see valtechspring.orm.dao.CustomerDAO#getAllCustomers(org.hibernate.Session)
     */
    @Override
    public List<Customer>getAllCustomers(Session session){
        return session.createQuery("SELECT c FROM Customer c" ).list();
    }
    
    /* (non-Javadoc)
     * @see valtechspring.orm.dao.CustomerDAO#getCustomer(org.hibernate.Session, int)
     */
    @Override
    public Customer getCustomer(Session session, int id){
        return (Customer) session.get(Customer.class, id);
        
    }
    @Override
    public double getCombinedBalance(Session session, int cid) {
        Query q = session.createQuery("select sum(a.balance) From Customer c Join c.accounts a where c.id= ?");
        q.setInteger(0, cid);
        return (Double) (q.list().size() == 0 ? 0 : q.list().get(0));
    }
    @Override
    public List<Customer> getByAccountType(Session session, String type) {
        Query q = session.getNamedQuery("customerByAccountType");
        q.setString(0, type);
        return q.list();
    }
    



}
// hr,l&d,shantala,purushotam