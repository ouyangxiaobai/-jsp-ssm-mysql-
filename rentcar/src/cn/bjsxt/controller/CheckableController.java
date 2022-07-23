package cn.bjsxt.controller;

import cn.bjsxt.pojo.Car;
import cn.bjsxt.pojo.Checktable;
import cn.bjsxt.pojo.Customer;
import cn.bjsxt.pojo.RentTable;
import cn.bjsxt.service.CarService;
import cn.bjsxt.service.ChecktableService;
import cn.bjsxt.service.CustomerService;
import cn.bjsxt.service.RenttableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Controller
public class CheckableController {
	
	@Autowired
	private ChecktableService checktableService;
	@Autowired
	private RenttableService rentTableService;
	@Autowired
	private CarService carService;
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("preAddCheckable")
	public String preAddRentTable(HttpServletRequest req){
		String rentNo = req.getParameter("rentNo");
		RentTable table =  rentTableService.findRentableByRentNo(rentNo);
		Customer customer = customerService.findCustomerByIdentity(table.getCustIdentity());
		Car car = carService.findCarByNumber(table.getCarNumber());
		
		String checkno =String.valueOf(new Date().getTime());
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String checktime = sdf.format(date);
		
		Checktable checktable = new Checktable();
		checktable.setCheckno(checkno);
		checktable.setChecktime(checktime);
		checktable.setUsername(table.getUserName());
		checktable.setRentid(table.getRentid());
		
		req.setAttribute("checktable", checktable);
		req.setAttribute("table", table);
		req.setAttribute("customer", customer);
		req.setAttribute("car", car);
		
		return "checktable";
	}
	
	@RequestMapping("addchecktable")
	public String addchecktable(Checktable checktable,HttpServletRequest req){
		RentTable rentTable = rentTableService.findTableById(checktable.getRentid());
		int row = checktableService.addChecktable(checktable,rentTable);
		if (row > 0) {
			return "success";
		}else{
			return "error";
		}
	}
	
	@RequestMapping("addCheckableByRentNo")
	public String addCheckableByRentNo(){
		return "addCheckableByRentNo";
	}
	
	@RequestMapping("findChecktable")
	public String findChecktable(){
		return "findChecktable";
	}
	
	@RequestMapping("findChecktableList")
	public String findChecktable(HttpServletRequest req){
		String username  = req.getParameter("username");
		String checkno = req.getParameter("checkno");
		String checktime = req.getParameter("checktime");
		String problem = req.getParameter("problem");
		String type = req.getParameter("type");
		String rentidstr = req.getParameter("rentid");
		String payingstr = req.getParameter("paying");
		String flag = req.getParameter("flag");
		Integer rentid = null;
		Double paying = null;
		if (rentidstr !="" && rentidstr != null) {
			rentid=Integer.parseInt(rentidstr);
		}
		if (payingstr !="" && payingstr != null) {
			paying=Double.parseDouble(payingstr);
		}
		Checktable checktable = new Checktable(null, username, rentid, checkno, checktime, problem, paying, type,flag);
		List<Checktable> checktables = checktableService.findChecktable(checktable);
		if (checktables != null) {
			req.setAttribute("checktables", checktables);
			return "listCheckTable";
		}else{
			return "error";
		}
	}
	
	@RequestMapping("preUpdateCheckTable")
	public String preUpdateCheckTable(HttpServletRequest req){
		String checkid = req.getParameter("checkid");
		Checktable checktable = checktableService.findChecktableById(checkid);
		RentTable table =  rentTableService.findTableById(checktable.getRentid());
		Customer customer = customerService.findCustomerByIdentity(table.getCustIdentity());
		Car car = carService.findCarByNumber(table.getCarNumber());
		
		req.setAttribute("checktable", checktable);
		req.setAttribute("table", table);
		req.setAttribute("customer", customer);
		req.setAttribute("car", car);
		
		return "updateChecktable";
	}
	
	@RequestMapping("updateChecktable")
	public String updateChecktable(Checktable checktable,HttpServletRequest req){

		int row = checktableService.updateChecktable(checktable);
		if (row > 0) {
			return "success";
		}else{
			return "error";
		}
	}
}
