package cn.bjsxt.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import cn.bjsxt.pojo.Menu;
import cn.bjsxt.pojo.Role;
import cn.bjsxt.pojo.User;
import cn.bjsxt.service.MenuService;
import cn.bjsxt.service.RoleService;

@Controller
public class RoleController {

	@Autowired
	RoleService roleService;
	@Autowired
	MenuService menuService;

	@RequestMapping("findAllRole")
	public String findAllRole(HttpServletRequest request) {
		List<Role> roles = roleService.findAllRole();
		// 通过request存储roles.
		request.setAttribute("roles", roles);
		return "role";
	}
	
	@RequestMapping("findRoleByName")
	public String findRoleByName(HttpServletRequest request) {
		String rolename = request.getParameter("rolename");
		String name = "%"+rolename+"%";
		List<Role> roles = roleService.findRoleByName(name);
		request.setAttribute("roles", roles);
		return "role";
	}
	
	@RequestMapping("deleteRole")
	public String deleteRole(Role role) {
		int roleid = role.getRoleid();
		// 通过用户ID取得菜单列表.
		int row = roleService.deleteRole(roleid);
		// 通过request存储menus.
		 return "redirect:/ findAllRole"; 
	}
	
	@RequestMapping("addRole.do")
	public String addRole(Role role,@RequestParam("menuId") List<Integer> list,HttpServletRequest request) {
		// 通过用户ID取得菜单列表.
		int row = roleService.addRole(role.getRolename(),list);
		// 通过request存储menus.
		 return "redirect:/ findAllRole"; 
	}
	@RequestMapping("showRoleMenu")
	public String showRoleMenu(Role role,HttpServletRequest request){
		System.out.println(role);
		List<Menu> menus = menuService.showMenu();
		request.setAttribute("menus", menus);
		List<Menu> roleMenus = roleService.findMenuById(role.getRoleid());
		request.setAttribute("roleMenus", roleMenus);
		request.setAttribute("role", role);
		return "updataRole";
	}
	
	@RequestMapping("updataRole.do")
	public String updataRole(Role role,@RequestParam("menuId") List<Integer> list,HttpServletRequest request) {
		int row = roleService.updataRole(role,list);
		
		return "redirect:/ findAllRole";
	}
	
	@RequestMapping("preAdduserData")
	@ResponseBody
	public String preAdduserData(HttpServletRequest request) {
		List<Role> roles = roleService.findAllRole();
		Gson gson = new Gson();
		String json = gson.toJson(roles);
		return json;
	}
}
