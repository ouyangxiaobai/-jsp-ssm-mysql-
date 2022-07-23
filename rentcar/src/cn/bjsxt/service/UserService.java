package cn.bjsxt.service;

import cn.bjsxt.pojo.User;

import java.util.List;

public interface UserService {
	
	User login(String name, String pwd, String dateTime, String addr);

	int deleteById(Integer userid);

	int addUser(User user);

	int updateUser(User user);

	List<User> findUsers(User user);

	User findUserByName(String username);

	User findUserById(int userid);
}
