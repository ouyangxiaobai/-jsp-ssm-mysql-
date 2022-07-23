package cn.bjsxt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bjsxt.mapper.MenuMapper;
import cn.bjsxt.pojo.Menu;
import cn.bjsxt.service.MenuService;

@Service
public class MenuServiceImpl implements MenuService{

	@Autowired
	MenuMapper menuMapper;
	@Override
	public List<Menu> findMenuByUserId(int id) {
		return menuMapper.findMenuByUserId(id);
	}
	@Override
	public List<Menu> showMenu() {
		return menuMapper.showMenu();
	}

}
