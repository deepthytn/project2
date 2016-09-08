package daoservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.UserModel;
import dao.DaoI;

@Service
@Transactional
public class DaoServiceIm implements DaoIServ{

	@Autowired
	DaoI ds;
	public List<UserModel> getAll()
	{
		
	return	ds.getAllproduct();
	}
	public void addproduct(UserModel p)
	{
		ds.addproduct(p);
	}
	public UserModel getRowById(int id){
		UserModel p=	ds.getRowById(id);
		return p;
	}
	public void updateRow(UserModel p){
		
		ds.updateRow(p);
	
	}
	 public void deleterow(UserModel p){
		 ds.deleterow(p);
	 }
}
