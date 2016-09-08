package dao;

import java.util.List;

import model.Forum;



public interface ForumDao {
	
	public List<Forum> getAllForum();
	public void addForum(Forum p);
	public Forum getRowById(int id);
	 public void updateRow(Forum p);
	 public void deleterow(Forum p);

}
