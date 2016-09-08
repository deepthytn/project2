package daoservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.BlogDao;
import model.Blog;

@Service
@Transactional
public class BlogDaoServiceImpl implements BlogDaoService{
	
	@Autowired
	BlogDao blogdao;
	
	public List<Blog> getAllBlog(){
		
		
	return	blogdao.getAllBlog();
	}
	public void addBlog(Blog p){
		
		blogdao.addBlog(p);
	}
	public Blog getRowById(int id){
		
		return blogdao.getRowById(id);
	}
	 public void updateRow(Blog p){
		 
		 blogdao.updateRow(p);
	 }
	 public void deleterow(Blog p){
		 
		 blogdao.deleterow(p);
	 }

}
