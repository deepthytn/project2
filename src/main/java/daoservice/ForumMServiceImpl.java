package daoservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.ForumModel;

@Service
public class ForumMServiceImpl implements ForumMServiceDao{
	@Autowired
	ForumModelDao forumModelDao;
	public ForumModel getRowById(int id){
		
		return forumModelDao.getRowById(id);
	}
	
	public int addNewForum(ForumModel f){
		
	return	forumModelDao.addNewForum(f);
	}
	public List<ForumModel> getAllForum(){
		
		return forumModelDao.getAllForum();
	}

}
