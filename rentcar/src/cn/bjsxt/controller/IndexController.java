package cn.bjsxt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.bjsxt.pojo.Menu;
import cn.bjsxt.pojo.User;
import cn.bjsxt.service.MenuService;

@Controller
public class IndexController {

	@Autowired
	MenuService menuService;

	@RequestMapping("index")
	public String index(User user, HttpServletRequest request) {
		// 通过session中的用户去拿到user的id
		User u = (User) request.getSession().getAttribute("currentUser");
		// 通过用户ID取得菜单列表.
		List<Menu> menus = menuService.findMenuByUserId(u.getUserid());
		// 通过request存储menus.
		request.setAttribute("menus", menus);
		return "index";
	}
	
	@RequestMapping("showMenu")
	public String showMenu(HttpServletRequest request) {
		// 通过用户ID取得菜单列表.
		List<Menu> menus = menuService.showMenu();
		// 通过request存储menus.
		request.setAttribute("menus", menus);
		return "addRole";
	}
}
