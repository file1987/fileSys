package com.file.system.action.user;

import com.file.system.exception.FileServiceException;
import com.file.system.model.user.User;
import com.file.system.service.user.UserMapper;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;
	private UserMapper userMapper;
	public String init(){
		return "success";
	}
	public String login(){
		System.out.println("LoginAction.login()"+user);
		User newUser = null;
		try {
			newUser = userMapper.getUser(user);
		} catch (FileServiceException e) {
			e.printStackTrace();
		}
		System.out.println("LoginAction.login()"+newUser);
		return "success";
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public UserMapper getUserMapper() {
		return userMapper;
	}
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
	

}
