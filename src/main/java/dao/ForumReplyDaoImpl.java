package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.ForumReply;

@Repository
@Transactional
public class ForumReplyDaoImpl implements ForumReplyDao{
	
	List<ForumReply> replies;
	
	 @Autowired
	 SessionFactory sessionFactory;
	 public List<ForumReply> getRepliesbyForum(int id){
			
			Session session = sessionFactory.getCurrentSession();  
		    Query q =session.createQuery("from ForumReply where forumid="+id);
		    replies =(List<ForumReply>)q.list();
		    	return replies;
		}
	
	public int addForumReply(ForumReply fr){
		System.out.println("dddddddddddddd");
		Session s=sessionFactory.getCurrentSession();
		s.save(fr);
		return 1;
	}
	
	public void updateRow(ForumReply p){
		
		 Session session = sessionFactory.getCurrentSession();
	        session.saveOrUpdate(p);
	        session.flush();
	}
	public void deleteForumReply(ForumReply p)
	{
		Session session = sessionFactory.getCurrentSession();
        session.delete(p);
	   System.out.println("aft del");
	   session.flush();
	}

}
