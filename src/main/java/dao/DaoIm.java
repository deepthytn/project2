package dao;

import java.io.Serializable;
import java.util.List;
import dao.DaoI;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.UserModel;

@Transactional
@Repository
public class DaoIm implements DaoI{
	List<UserModel> prods;
	
	 @Autowired
 SessionFactory sessionFactory;

	   public DaoIm(){
		   
	   }
	   public List<UserModel> getAllproduct() 
	   {
		   
		   Session session = sessionFactory.getCurrentSession();  
		    Query q =session.createQuery("from UserModel");
		    	prods =(List<UserModel>)q.list();
		    	return prods;
	   }
	   
	   public void addproduct(UserModel p)
	   {
		   System.out.println("In save");
			Session s=sessionFactory.getCurrentSession();
			System.out.println("After current");
			s.save(p);
			System.out.println("After Save");		
			s.flush();
	   }
	   public UserModel getRowById(int id){
		   
		   Session s=sessionFactory.openSession();
		   Transaction trx=s.beginTransaction();
		   
		   UserModel p=(UserModel)s.load(UserModel.class, id);
		  trx.commit();
		  s.close();
		   return p;
		   
	   }
	   
	  
	   public void updateRow(UserModel p) {
		   Session session = sessionFactory.getCurrentSession();
	        session.saveOrUpdate(p);
	        session.flush();
	   
	   }
	   public void deleterow(UserModel p)
	   {
		   Session session = sessionFactory.getCurrentSession();
	        session.delete(p);
		   System.out.println("aft del");
		   session.flush();
		   
	   }

}
