package daoservice;

import java.util.List;

import model.ForumModel;

public interface ForumMServiceDao {
	public ForumModel getRowById(int id);
	public void getReplysByUser(String Username);
	public int addNewForum(ForumModel f);
	public List<ForumModel> getAllForum();

}
