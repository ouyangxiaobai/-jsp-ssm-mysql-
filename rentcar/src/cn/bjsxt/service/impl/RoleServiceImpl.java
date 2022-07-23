package cn.bjsxt.service.impl;

import cn.bjsxt.mapper.RoleMapper;
import cn.bjsxt.pojo.Menu;
import cn.bjsxt.pojo.Role;
import cn.bjsxt.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	RoleMapper roleMapper;
	@Override
	public List<Role> findAllRole() {
		return roleMapper.findAllRole();
	}
	@Override
	public List<Role> findRoleByName(String name) {
		return roleMapper.findRoleLikeName(name);
	}
	@Override
	public int deleteRole(int roleid) {
		return roleMapper.deleteRole(roleid);
	}
	@Override
	public int addRole(String rolename, List<Integer> list) {
		int row1 = roleMapper.insertRoleByName(rolename);
		if (row1 > 0) {
			Role role= roleMapper.findRoleByName(rolename);
			for (int i = 0; i < list.size(); i++) {
				int row = roleMapper.addRoleMenu(role.getRoleid(),list.get(i));
				if (row < 1) {
					return row;
				}
			}
			return row1;
		}else{
			return row1;
		}
		
	}
	@Override
	public List<Menu> findMenuById(int roleid) {
		return roleMapper.findMenuById(roleid);
	}
	@Override
	public int updataRole(Role role, List<Integer> list) {
		int row = roleMapper.deleteRole(role.getRoleid());
		if (row > 0) {
			int row1 = roleMapper.insertRole(role.getRoleid(),role.getRolename());
			if (row1 > 0) {
				for (int i = 0; i < list.size(); i++) {
					int row2 = roleMapper.addRoleMenu(role.getRoleid(),list.get(i));
					if (row2 < 1) {
						return row2;
					}
				}
			}
		}
		return row;
	}
	@Override
	public Role getRoleById(int roleid) {
		return roleMapper.getRoleById(roleid);
	}

}
