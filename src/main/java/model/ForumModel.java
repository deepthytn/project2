package model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class ForumModel implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int  forumid;
	String Username;
	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	String subject,description;

	@ManyToOne
	@JoinColumn(name="replyid")
	private ForumReply forumreply;

	public int getForumid() {
		return forumid;
	}

	public void setForumid(int forumid) {
		this.forumid = forumid;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ForumReply getForumreply() {
		return forumreply;
	}

	public void setForumreply(ForumReply forumreply) {
		this.forumreply = forumreply;
	}
	
	
}
