package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;

@Entity
@Table(name="forum")
public class Forum {
	//create table forum(forumid varchar(10),forumquestion varchar2(max))
	@Id
	String forumid;
	
	String forumquestion;
	public String getForumid() {
		return forumid;
	}
	public void setForumid(String forumid) {
		this.forumid = forumid;
	}
	public String getForumquestion() {
		return forumquestion;
	}
	public void setForumquestion(String forumquestion) {
		this.forumquestion = forumquestion;
	}
	
	
}
