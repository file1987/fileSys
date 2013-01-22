package com.file.system.service.user;

import com.file.system.exception.FileServiceException;
import com.file.system.model.user.User;
/**
 * 用户service层接口
 * @author wwj
 *
 */
public interface UserMapper {
	public User getUser(User user) throws FileServiceException;	
}
