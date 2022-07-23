package cn.bjsxt.mapper;

import java.util.List;

import cn.bjsxt.pojo.Menu;
import cn.bjsxt.pojo.Role;

public interface RoleMapper {
	/**
	 * 根据角色名查询菜单列表
	 * @param name
	 * @return
	 */

	List<Role> findAllRole();

	int deleteRole(int roleid);

	int insertRoleByName(String rolename);


	List<Role> findRoleLikeName(String name);

	Role findRoleByName(String rolename);

	int addRoleMenu(int roleid, Integer integer);

	List<Menu> findMenuById(int roleid);

	int insertRole(int roleid, String rolename);

	Role getRoleById(int roleid);
}
