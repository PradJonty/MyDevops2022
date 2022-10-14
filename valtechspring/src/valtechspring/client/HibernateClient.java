package valtechspring.client;

import java.util.Date;

import java.util.List;
import java.time.LocalDate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import javafx.util.converter.LocalDateStringConverter;
import valtechspring.orm.Account;
import valtechspring.orm.Address;
import valtechspring.orm.AtmTx;
import valtechspring.orm.BankAccount;
import valtechspring.orm.BankAccountId;
import valtechspring.orm.Car;
import valtechspring.orm.CarDetails;
import valtechspring.orm.ChequeTx;
import valtechspring.orm.Customer;
import valtechspring.orm.TellerTx;
import valtechspring.orm.Tx;
import valtechspring.orm.dao.CustomerDAO;
import valtechspring.orm.dao.CustomerDAOImpl;

import java.time.LocalDate;


public class HibernateClient {

    public static void main(String[] args) {
//        SessionFactory sf = new Configuration()
        SessionFactory sf = new AnnotationConfiguration()
                .configure()
            //  .addClass(Car.class)
                .addAnnotatedClass(Car.class)
                .addAnnotatedClass(BankAccount.class)
                .addAnnotatedClass(Tx.class )
                .addAnnotatedClass(TellerTx.class)
                .addAnnotatedClass(AtmTx.class)
                .addAnnotatedClass(ChequeTx.class)
                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Address.class)
                .addAnnotatedClass(Account.class)
                .buildSessionFactory();  // not possible to add another class now // Dont create two session factoy
                
     
        Session ses = sf.openSession();
        Transaction tx = ses.beginTransaction();
        Customer c1 = new Customer("Abc",LocalDate.of(90, 6, 10),1);
        ses.save(c1);
        Customer c2 = new Customer("prad",LocalDate.of(80, 6, 10),1);
        ses.save(c2);
        Customer c3 = new Customer("jonty",LocalDate.of(90, 6, 10),1);
        ses.save(c3);
        CustomerDAO customerDAO = new CustomerDAOImpl(); // fetching the data
        //for(Customer c : customerDAO.getByAccountBalanceGreaterThan(ses, 5000)){
        	//System.out.println(c);
        //}
        
        System.out.println("combined balance for cus1= "+customerDAO.getCombinedBalance(ses, 160));
        System.out.println("combined balance for cus2= "+customerDAO.getCombinedBalance(ses, 180));
        System.out.println("combined balance for cus4= "+customerDAO.getCombinedBalance(ses, 180));
        System.out.println("combined balance for cus5= "+customerDAO.getCombinedBalance(ses, 180));
        
        List objects=ses.createQuery("Select o from java.lang.Object o").list();
        for (Object o : objects) {
            System.out.println(o);
        }
        
        
//     Customer c = new Customer("Abc",LocalDate.of(90, 6, 10),1);
//        Address a = new Address("UB ","Blr","Kar",560078);
//        ses.save(c);
//        ses.save(a);
//        c.setAddress(a);
// 
//       Customer c1 =  new Customer("Abc",LocalDate.of(90, 6, 10),1);
//       
//        Account ac=new Account(1000,"SB");
//        Account ac1=new Account(1000,"CA");
//        ses.save(ac);
//        ses.save(ac1);
//        
//        Account ac2 = new Account(2000,"SB");
//        Account ac3 = new Account(3000,"SB");
//        
//        c.addAccount(ac);
//        c.addAccount(ac3);
//        c.addAccount(ac2);
//        
//        c1.addAccount(ac3);
//        c1.addAccount(ac2);
//        
//        List<Tx> txs=ses.createQuery("SELECT tx From Tx tx").list();
//        for(Tx t:txs){
//            //ternary operator boolCond ? true:false
//            t.setAccount(t.getId()%2==0 ? ac:ac1);
//        }
        
      //  Customer c = new Customer("Xyz",LocalDate.of(1947, 6, 10),1);
        //Address a = new Address("UB City","Blr","Kar",560076);
        //ses.save(c);
        //ses.save(a);
        //a.setCustomer(c);
        //c.setAddress(a);
        
       // ses.save(new Tx(1000));
        //ses.save(new ChequeTx(2000,123456,false,2));
        //ses.save(new TellerTx(2500, "Teller1", "J.P.Nagar"));
        //ses.save(new AtmTx(3000, 123, "Jayanagar"));
         //List<Tx> txs = ses.createQuery("SELECT tx from Tx tx").list();
        //for(Tx t:txs){
          //  System.out.println(t);
        
        //}
        
        
        
        tx.commit();
        ses.close();
        sf.close();
    }
}