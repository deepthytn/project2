package daoservice;

import java.util.List;

import model.Blog;

public interface BlogDaoService {
	public List<Blog> getAllBlog();
	public void addBlog(Blog p);
	public Blog getRowById(int id);
	 public void updateRow(Blog p);
	 public void deleterow(Blog p);
}
