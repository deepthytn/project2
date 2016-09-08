package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.Blog;


@Transactional
@Repository
public class BlogDaoImpl implements BlogDao{
	
	List<Blog> prods;
	
	 @Autowired
SessionFactory sessionFactory;

	   public BlogDaoImpl(){
		   
	   }
	   public List<Blog> getAllBlog()
	   {
		   
		   Session session = sessionFactory.getCurrentSession();  
		    Query q =session.createQuery("from Blog");
		    	prods =(List<Blog>)q.list();
		    	return prods;
	   }
	   
	   public void addBlog(Blog p)
	   {
		   System.out.println("In save");
			Session s=sessionFactory.getCurrentSession();
			System.out.println("After current");
			s.save(p);
			System.out.println("After Save");		
			s.flush();
	   }
	   public Blog getRowById(int id){
		   
		   Session s=sessionFactory.openSession();
		   Transaction trx=s.beginTransaction();
		   
		   Blog p=(Blog)s.load(Blog.class, id);
		  trx.commit();
		  s.close();
		   return p;
		   
	   }
	   
	  
	   public void updateRow(Blog p) {
		   Session session = sessionFactory.getCurrentSession();
	        session.saveOrUpdate(p);
	        session.flush();
	   
	   }
	   public void deleterow(Blog p)
	   {
		   Session session = sessionFactory.getCurrentSession();
	        session.delete(p);
		   System.out.println("aft del");
		   session.flush();
		   
	   }


}
