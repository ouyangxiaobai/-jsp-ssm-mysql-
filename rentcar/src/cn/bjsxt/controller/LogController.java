package cn.bjsxt.controller;

import cn.bjsxt.pojo.Loginlog;
import cn.bjsxt.pojo.Logtable;
import cn.bjsxt.pojo.User;
import cn.bjsxt.service.LogtableService;
import cn.bjsxt.utils.MyPageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LogController {
	@Autowired
	LogtableService logtableService;
	@RequestMapping("findLoginlog")
	public String findLoginlog(User user,HttpServletRequest request) {
		MyPageBean<Loginlog> mpb = new MyPageBean<Loginlog>();
		String indexStr = request.getParameter("index");
		String sizeStr = request.getParameter("size");
		if (indexStr != null && !"".equals(indexStr)) {
			mpb.setIndex(Integer.parseInt(indexStr));
		}
		if (sizeStr != null && !"".equals(sizeStr)) {
			mpb.setSize(Integer.parseInt(sizeStr));
		}
		String username = user.getUsername();
		String name;
		if (username == null) {
			name="%%";
		}else{
			name = "%"+username+"%";
		}
		// 通过用户ID取得菜单列表.
		logtableService.findLoginlog(mpb,name);
		// 通过request存储menus.
		request.setAttribute("mpb", mpb);
		request.setAttribute("username",username);
		return "loginlog";
	}
	
	@RequestMapping("findLogtable")
	public String findLogtable(User user,HttpServletRequest request) {
		MyPageBean<Logtable> mpb = new MyPageBean<Logtable>();
		String indexStr = request.getParameter("index");
		String sizeStr = request.getParameter("size");
		if (indexStr != null && !"".equals(indexStr)) {
			mpb.setIndex(Integer.parseInt(indexStr));
		}
		if (sizeStr != null && !"".equals(sizeStr)) {
			mpb.setSize(Integer.parseInt(sizeStr));
		}

		String username = user.getUsername();
		String name;
		if (username == null) {
			name="%%";
		}else{
			name = "%"+username+"%";
		}
		// 通过用户ID取得菜单列表.
		logtableService.findLogtable(mpb,name);
		// 通过request存储menus.
		request.setAttribute("mpb", mpb);
		request.setAttribute("username",username);
		return "logtable";
	}
}
