package dao;

import java.util.List;


import model.UserModel;
public interface DaoI {
	public List<UserModel> getAllproduct();
	public void addproduct(UserModel p);
	public UserModel getRowById(int id);
	 public void updateRow(UserModel p);
	 public void deleterow(UserModel p);
}
