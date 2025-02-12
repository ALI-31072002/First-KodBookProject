package com.KodBook.Services;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.KodBook.Repositories.UserRepository;
import com.KodBook.entities.User;

@Service
public class UserServiceImplementation  implements UserService{
	@Autowired
	UserRepository repo;

	@Override
	public void addUser(User user) {
		repo.save(user);
	}
	
	@Override
	public boolean userExists(String username, String email) {
	 
	User user1=repo.findByUsername(username);
	User user2=repo.findByEmail(email);
	if(user1!=null || user2!=null) {
		return true;
	}
	else {
		return false;
	}
}
	@Override
	public boolean validateUser(String username, String password) {
		String dbPass=repo.findByUsername(username).getPassword();
		if(password.equals(dbPass)) {
			return true;
		}
		else {
			return false;
		}
	}

}
