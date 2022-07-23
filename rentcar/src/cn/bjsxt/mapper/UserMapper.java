package cn.bjsxt.mapper;

import cn.bjsxt.pojo.User;

import java.util.List;

public interface UserMapper {

	User login(String name,String pwd);

	int addLoginlog(String name, String addr, String dateTime);

	/**
	 * 删除方法
	 * @param userid
	 * @return
	 */
	int deleteById(int userid);
	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	int addUser(User user);
	/**
	 * 修改方法
	 * @param user
	 * @return
	 */
	int updateUser(User user);
	/**
	 * 查询方法
	 * @param user
	 * @return
	 */
	List<User> findUsers(User user);

	User findUserByName(String username);

	User findUserById(int userid);
}
