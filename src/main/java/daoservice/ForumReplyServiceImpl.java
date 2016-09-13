package daoservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ForumReplyDao1;
import model.ForumReply;

@Service
public class ForumReplyServiceImpl implements ForumReplyISerivce{
	@Autowired
	ForumReplyDao1 frDao;
public ForumReply getRowById(int id){
	
	return frDao.getRowById(id);
}
	
	public int addNewReply(ForumReply f){
		
		return frDao.addForumReply(f);
	}
	public List<ForumReply> getAllForumReply(){
		
	return	frDao.getAllForumReply();
	}

}
