package cn.bjsxt.service;

import java.util.List;

import cn.bjsxt.pojo.Menu;

public interface MenuService {
	/**
	 * 根据用户ID查询菜单列表
	 * @param id
	 * @return
	 */
	List<Menu> findMenuByUserId(int id);


	List<Menu> showMenu();
}
