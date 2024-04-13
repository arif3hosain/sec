package com.app.service;

import com.app.model.User;
import com.app.other.Other;
import com.app.repository.UserRepository;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void save(User user) {
		user.setPassword(Other.encrypt(user.getPassword()));
		userRepository.save(user);
	}

	@Override
	public void update(User user, HttpServletRequest request) {

		User u = userRepository.getOne(user.getId());
		u.setPassword(Other.encrypt(user.getPassword()));
		u.setSchool(user.getSchool());
		userRepository.save(u);
		this.updateSession(request, u);
	}

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public void login(String username, String password, HttpServletRequest request) {
		// Check if the username exists in the database
		User user = userRepository.findByUsername(username);

		// Authentication successful, set session attribute and redirect to welcome page
		HttpSession session = request.getSession(true); // Create a new session if it doesn't exist
		session.setAttribute("loggedInUser", user); // Store the logged-in user in the session
	}

	@Override
	public User loginUser( HttpServletRequest request){
		return (User) request.getSession().getAttribute("loggedInUser");
	}

	@Override
	public void updateSession( HttpServletRequest request, User user){
		 request.getSession().setAttribute("loggedInUser", user);
	}

	@Override
	public boolean isLogin( HttpServletRequest request){
		User user = (User) request.getSession().getAttribute("loggedInUser");
		return user != null;
	}


}
