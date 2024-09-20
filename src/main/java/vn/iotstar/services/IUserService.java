package vn.iotstar.services;

import vn.iotstar.models.UserModel;

public interface IUserService {
	
	UserModel login(String username, String password);
	
	UserModel FindByUserName(String username);

	void insert(UserModel user);
	
	UserModel FindByEmail(String email);

	void update(UserModel user);

	
	
	
}
