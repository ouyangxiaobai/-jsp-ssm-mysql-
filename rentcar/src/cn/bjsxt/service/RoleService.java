package cn.bjsxt.service;

import java.util.List;

import cn.bjsxt.pojo.Menu;
import cn.bjsxt.pojo.Role;

public interface RoleService {
	/**
	 * 根据角色name查询菜单列表
	 * @param name
	 * @return
	 */


	List<Role> findAllRole();

	List<Role> findRoleByName(String name);

	int deleteRole(int roleid);

	int addRole(String rolename, List<Integer> list);

	List<Menu> findMenuById(int roleid);

	int updataRole(Role role, List<Integer> list);

	Role getRoleById(int roleid);
}
