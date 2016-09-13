package model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name="forumreply")
public class ForumReply implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int replyid;
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	String Usernames;
	String description;
	String myreply;
	int likes,forumid;
	public int getReplyid() {
		return replyid;
	}
	public void setReplyid(int replyid) {
		this.replyid = replyid;
	}
	public String getUsername() {
		return Usernames;
	}
	public void setUsername(String username) {
		this.Usernames = username;
	}
	public String getMyreply() {
		return myreply;
	}
	public void setMyreply(String myreply) {
		this.myreply = myreply;
	}
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	public int getForumid() {
		return forumid;
	}
	public void setForumid(int forumid) {
		this.forumid = forumid;
	}
	public UserModel getUser() {
		return user;
	}
	public void setUser(UserModel user) {
		this.user = user;
	}
	@ManyToOne
	@JoinColumn(name="username")
	@JsonIgnore
	private UserModel user;
	
	
	
	}
