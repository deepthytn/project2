package daoservice;

import java.util.List;
import model.UserModel;

public interface DaoIServ {
	public List<UserModel> getAll();
	public void addproduct(UserModel p);
	public UserModel getRowById(int id);
	public void updateRow(UserModel p);
	 public void deleterow(UserModel p);
}
