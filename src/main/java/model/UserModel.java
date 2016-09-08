package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import java.io.Serializable;


import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="UserModel")
public class UserModel implements Serializable {
	@Id
	int id;
	String name;
String address;
String email;
private String userrole;
private String username;
String password;

@Transient
private MultipartFile image;



public MultipartFile getImage() {
	return image;
}
public void setImage(MultipartFile image) {
	this.image = image;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getUserrole() {
	return userrole;
}
public void setUserrole(String userrole) {
	this.userrole = userrole;
}
public UserModel()
{
	
}
public UserModel(int id,String pname,String userrole,String username,String address,String email,String password)
{
	this.id=id;
	this.name=pname;
	this.username = username;
	this.address=address;
	this.email=email;
	this.userrole = userrole;
	this.password=password;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
@Override
public String toString() {
	return "UserModel[ id="+id+", name="+name+
			",address="+ address+",email"+email+",username"+username+",userrole"+userrole+",password"+password+"]";
}

}
