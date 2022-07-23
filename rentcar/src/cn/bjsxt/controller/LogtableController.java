/*package cn.bjsxt.controller;


import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import cn.bjsxt.pojo.Logtable;
import cn.bjsxt.pojo.User;
import cn.bjsxt.service.MenuService;
@Aspect
@Component
@Controller
public class LogtableController {
	Logtable logtalbe;
	@Autowired
	MenuService menuService;

	@After("execution(* cn.bjsxt.controller.RoleController.deleteRole(..))")
	public void deleteRoleLogtalbe() {
		System.out.println("deleteRole");
	}
	@AfterReturning("execution(* cn.bjsxt.controller.RoleController.addRole(..))")
	public void addRoleLogtalbe(JoinPoint joinpoint) {
		Object[] args = joinpoint.getArgs();
		for (int i = 0; i < args.length; i++) {
			System.out.println(args[i]);
		}
	}
	
	
	
	private void setLogtable(HttpServletRequest request) {
		User user = (User)request.getSession().getAttribute("user");
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateTime = sdf.format(date);
		logtalbe.setUserid(user.getUserid());
		logtalbe.setActionTime(dateTime);
	}
	
}*/
