package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import model.Forum;

@Transactional
@Repository
public class ForumDaoImpl implements ForumDao{

	List<Forum> prods;
	
	 @Autowired
	 SessionFactory sessionFactory;

	   public ForumDaoImpl(){
		   
	   }
	   public List<Forum> getAllForum()
	   {
		   
		   Session session = sessionFactory.getCurrentSession();  
		    Query q =session.createQuery("from Forum");
		    	prods =(List<Forum>)q.list();
		    	return prods;
	   }
	   
	   public void addForum(Forum p)
	   {
		   System.out.println("In save");
			Session s=sessionFactory.getCurrentSession();
			System.out.println("After current");
			s.save(p);
			System.out.println("After Save");		
			s.flush();
	   }
	   public Forum getRowById(int id){
		   
		   Session s=sessionFactory.openSession();
		   Transaction trx=s.beginTransaction();
		   
		   Forum p=(Forum)s.load(Forum.class, id);
		  trx.commit();
		  s.close();
		   return p;
		   
	   }
	   
	  
	   public void updateRow(Forum p) {
		   Session session = sessionFactory.getCurrentSession();
	        session.saveOrUpdate(p);
	        session.flush();
	   
	   }
	   public void deleterow(Forum p)
	   {
		   Session session = sessionFactory.getCurrentSession();
	        session.delete(p);
		   System.out.println("aft del");
		   session.flush();
		   
	   }



}
