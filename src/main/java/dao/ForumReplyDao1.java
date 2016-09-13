package dao;

import java.util.List;

import model.Blog;
import model.ForumModel;
import model.ForumReply;

public interface ForumReplyDao1 {
public ForumReply getRowById(int id);
	
	public int addForumReply(ForumReply f);
	public List<ForumReply> getAllForumReply();
}
