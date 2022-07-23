package cn.bjsxt.interceptor;

import cn.bjsxt.pojo.Logtable;
import cn.bjsxt.pojo.User;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseLogtable {

	Logtable logtable = new Logtable();
	
	public void setLogtable(HttpServletRequest request) {
		User user = (User)request.getSession().getAttribute("currentUser");
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateTime = sdf.format(date);
		logtable.setUserid(user.getUserid());
		logtable.setUsername(user.getUsername());
		logtable.setActiontime(dateTime);
	}
}
