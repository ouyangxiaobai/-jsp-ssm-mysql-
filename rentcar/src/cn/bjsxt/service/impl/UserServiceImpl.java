package cn.bjsxt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bjsxt.mapper.UserMapper;
import cn.bjsxt.pojo.Loginlog;
import cn.bjsxt.pojo.User;
import cn.bjsxt.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserMapper userMapper;
	@Override
	public User login(String name, String pwd, String dateTime, String addr) {
		int row = userMapper.addLoginlog(name,addr,dateTime);
		if (row > 0) {
			return userMapper.login(name, pwd);
		}else{
			return null;
		}
	}
	
	
	@Override
	public int deleteById(Integer userid) {
		return userMapper.deleteById(userid);
	}
	@Override
	public int addUser(User user) {
		return userMapper.addUser(user);
	}

	@Override
	public int updateUser(User user) {
		return userMapper.updateUser(user);
	}

	@Override
	public List<User> findUsers(User user) {
		return userMapper.findUsers(user);
	}


	@Override
	public User findUserByName(String username) {
		return userMapper.findUserByName(username);
	}


	@Override
	public User findUserById(int userid) {
		return userMapper.findUserById(userid);
	}

}
