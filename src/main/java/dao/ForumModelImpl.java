package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import daoservice.ForumModelDao;
import model.Forum;
import model.ForumModel;

@Repository
@Transactional
public class ForumModelImpl implements ForumModelDao {
	
	@Autowired
	SessionFactory sf;
	
	List<ForumModel> flist;
	  public ForumModel getRowById(int id){
		   
		   Session s=sf.openSession();
		   Transaction trx=s.beginTransaction();
		   
		   ForumModel p=(ForumModel)s.load(ForumModel.class, id);
		  trx.commit();
		  s.close();
		   return p;
		   
	   }
	public void getReplysByUser(String Username){
		
		Session s=sf.getCurrentSession();
	}
	public int addNewForum(ForumModel f){
		
		Session s=sf.getCurrentSession();
		s.save(f);
		return 1;
	}
	public List<ForumModel> getAllForum(){
		
		 Session session = sf.getCurrentSession();  
		    Query q =session.createQuery("from ForumModel");
		    	flist =(List<ForumModel>)q.list();
		    	return flist;
	}
}
