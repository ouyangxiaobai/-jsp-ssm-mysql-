package cn.bjsxt.controller;


import cn.bjsxt.pojo.RentTable;
import cn.bjsxt.service.RenttableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@Controller
public class StatisticsController {
	@Autowired
	private RenttableService rentTableService;
	
	@RequestMapping("StatisticsCarInMonth")
	public String StatisticsCarInMonth(HttpServletRequest req){
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		String endTime = sdf.format(date);
		List<RentTable> rentTables = rentTableService.findRentableByEndTime(endTime);
		req.setAttribute("tables", rentTables);
		return "listRentTableInMonth";
	}
}
