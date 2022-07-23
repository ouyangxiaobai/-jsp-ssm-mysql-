package cn.bjsxt.mapper;

import java.util.List;

import cn.bjsxt.pojo.Menu;

public interface MenuMapper {
	/**
	 * 根据用户ID查询菜单列表
	 * @param id
	 * @return
	 */
	List<Menu> findMenuByUserId(int id);

	List<Menu> showMenu();
}
