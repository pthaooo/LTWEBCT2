package vn.iotstar.services.impl;

import vn.iotstar.dao.IUserDao;
import vn.iotstar.dao.impl.UserDaoImpl;
import vn.iotstar.models.UserModel;
import vn.iotstar.services.IUserService;

public class UserService implements IUserService{
	
	IUserDao userDao = new UserDaoImpl();//lay toan bo ham trong tang DAO cua user

	@Override
	public UserModel login(String username, String password) {
		UserModel user = this.FindByUserName(username);
		if(user != null && password.equals(user.getPassword())) {
			return user;
		}
		return null;
	}

	@Override
	public UserModel FindByUserName(String username) {
		return userDao.findByUserName(username);
	}
	
	 @Override
	    public void insert(UserModel user) {
	        userDao.insert(user);
	    }
	 
	 public void update(UserModel user) {
		    userDao.update(user); 
		}

	@Override
	public UserModel FindByEmail(String email) {
		return userDao.findByEmail(email);
	}

}
