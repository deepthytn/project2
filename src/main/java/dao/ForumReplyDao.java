package dao;

import java.util.List;


import model.ForumReply;

public interface ForumReplyDao {

	public int addForumReply(ForumReply fr);
	public List<ForumReply> getRepliesbyForum(int id);
	public void updateRow(ForumReply p);
	public void deleteForumReply(ForumReply p);
	
}
