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
import model.ForumReply;

@Repository
@Transactional
public class ForumReplyDaoImpl2 implements ForumReplyDao1 {
	
	@Autowired
	SessionFactory sf;
	
	List<ForumReply> flist;
	
	  public ForumReply getRowById(int id){
		   
		   Session s=sf.openSession();
		   Transaction trx=s.beginTransaction();
		   
		   ForumReply p=(ForumReply)s.load(ForumReply.class, id);
		  trx.commit();
		  s.close();
		   return p;
		   
	   }
	
	public int addForumReply(ForumReply f){
		
		Session s=sf.getCurrentSession();
		s.save(f);
		return 1;
	}
	public List<ForumReply> getAllForumReply(){
		
		 Session session = sf.getCurrentSession();  
		    Query q =session.createQuery("from ForumReply");
		    	flist =(List<ForumReply>)q.list();
		    	return flist;
	}
}
