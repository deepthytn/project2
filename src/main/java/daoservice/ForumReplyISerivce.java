package daoservice;

import java.util.List;

import model.ForumModel;
import model.ForumReply;

public interface ForumReplyISerivce {
	public ForumReply getRowById(int id);
	
	public int addNewReply(ForumReply f);
	public List<ForumReply> getAllForumReply();

}
