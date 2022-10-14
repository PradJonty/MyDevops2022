package valtechspring.client;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;


import valtechspring.orm.Article;
import valtechspring.orm.Author;
import valtechspring.orm.Blog;
import valtechspring.orm.Book;
import valtechspring.orm.HandBook;
import valtechspring.orm.MyAddress;
import valtechspring.orm.Publisher;


public class PublisherClient {
	
	public static void main(String[] args) {
		 SessionFactory sf = (SessionFactory) new AnnotationConfiguration()
	                .configure()
	                .addAnnotatedClass(Publisher.class)
	                .addAnnotatedClass(Book.class)
	                .addAnnotatedClass(Author.class )
	                .addAnnotatedClass(MyAddress.class)
	                .addAnnotatedClass(Article.class)
	                .addAnnotatedClass(Blog.class)
	                .addAnnotatedClass(HandBook.class)
	                .buildSessionFactory();
		 
		 Session ses = sf.openSession();
		    Transaction tx = ses.beginTransaction();
		
		   // Publisher publisher=new Publisher();
		  Publisher pu=new Publisher("ranbir"," bangalore",1234567890);
		    ses.save(pu);
		    
		   Author author=new Author(1," ronaldo",1234567890);
		    ses.save(author);
		    
		    Book book=new Book(1," ronaldo",1947);
		    ses.save(book);
		    
		  MyAddress myaddress=new MyAddress(1," thames","liverpool","kanakpura","mystore",560076);
		    ses.save(myaddress);
		  
		    Blog blog=new Blog("united",89);
		    ses.save(blog);
		    
		    Article article=new Article("chelsea");
		    ses.save(article);
		    
		 HandBook handbook =new HandBook(2978,89,12);
		   ses.save(handbook);
		    
		    tx.commit();
		    ses.close();
		    sf.close();
		    //int id, String street, String city, String store, String state, int zipcode
	}
}
