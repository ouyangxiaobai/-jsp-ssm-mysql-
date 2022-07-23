package cn.bjsxt.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.bjsxt.pojo.User;
import cn.bjsxt.service.LogtableService;

public class CheckTableAddLogtalbe extends BaseLogtable implements HandlerInterceptor{
	@Autowired
	LogtableService logtableService;
	

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object arg2, Exception arg3) throws Exception {
		setLogtable(request);
		logtable.setAction("完成还车");
		int row = logtableService.addLogtable(logtable);
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3) throws Exception {
		
	}

	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		return true;
	}
	
}
