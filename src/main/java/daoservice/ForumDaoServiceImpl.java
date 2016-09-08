package daoservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.ForumDao;
import model.Forum;


@Service
@Transactional
public class ForumDaoServiceImpl implements ForumDaoIService{
	
	@Autowired
	ForumDao forumdao;
	
	public List<Forum> getAllForum(){
		
		return forumdao.getAllForum();
	}
	public void addForum(Forum p){
		
		forumdao.addForum(p);
	}
	public Forum getRowById(int id){
		
	return	forumdao.getRowById(id);
	}
	 public void updateRow(Forum p){
		 forumdao.updateRow(p);
		 
	 }
	 public void deleterow(Forum p){
		 forumdao.deleterow(p);
		 
	 }
	
	

}
