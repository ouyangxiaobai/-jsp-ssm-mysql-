package cn.bjsxt.controller;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import cn.bjsxt.pojo.Car;
import cn.bjsxt.pojo.Customer;
import cn.bjsxt.pojo.Menu;
import cn.bjsxt.pojo.RentTable;
import cn.bjsxt.pojo.User;
import cn.bjsxt.service.CarService;
import cn.bjsxt.service.CustomerService;
import cn.bjsxt.service.MenuService;
import cn.bjsxt.service.RenttableService;
import cn.bjsxt.service.UserService;

@Controller
public class RentableController {
	@Autowired
	private RenttableService rentTableService;
	@Autowired
	private CarService carService;
	@Autowired
	private UserService userService;
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("updateRentTableHandler")
	public String updateTableHandler(HttpServletRequest req) throws ParseException{
		//获取前台数据
		int rentId = Integer.parseInt(req.getParameter("rentid"));
		String realEndTime  = req.getParameter("realEndTime");
		String beginTime = req.getParameter("beginTime");
		String endTime = req.getParameter("endTime");
		String userName = req.getParameter("username");
		
		//对前台数据进行处理，准备好查询数据
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date ret = null;
		Date bt = null;
		Date et = null;
		if( realEndTime!=null && realEndTime!="" ){
			ret = new Date(sdf.parse(realEndTime).getTime());
		}
		if( beginTime!=null && beginTime!="" ){
			bt = new Date(sdf.parse(beginTime).getTime());
		}
		if( endTime!=null && endTime!="" ){
			et = new Date(sdf.parse(endTime).getTime());
		}
		RentTable rentTable = new RentTable();
		rentTable.setRentid(rentId);
		rentTable.setRealEndTime(ret);
		rentTable.setBeginTime(bt);
		rentTable.setEndTime(et);
		rentTable.setUserName(userName);
		int result = rentTableService.updateRentTable(rentTable);
		if(result>0){
			return "success";
		}
		return "error";
	}
	
	/**
	 * 修改出租单预处理
	 * @param req
	 * @return
	 */
	@RequestMapping("preUpdateRentTable")
	public String updateRentTable(HttpServletRequest req){
		int rentId = Integer.parseInt( req.getParameter("rentid") );
		RentTable table = rentTableService.findTableById(rentId);
		Customer customer = customerService.findCustomerByIdentity(table.getCustIdentity());
		Car car = carService.findCarByNumber(table.getCarNumber());
		req.setAttribute("table", table);
		req.setAttribute("customer", customer);
		req.setAttribute("car", car);
		return "updateRentTable";
	}
	
	/**
	 * 废弃出租单
	 * @param req
	 * @return
	 */
	@RequestMapping("dropRentTable")
	@ResponseBody
	public String dropRentTable(HttpServletRequest req){
		int rentTableId = Integer.parseInt(req.getParameter("rentTableId"));
		int r1  = rentTableService.dropRentTable(rentTableId);
		RentTable rentTable = rentTableService.findTableById(rentTableId);
		Map<String, String> map = new HashMap<String, String>();
		map.put("carNumber", rentTable.getCarNumber());
		map.put("flag", "0");
		int r2 = carService.changeFlagByNumber(map);
		if(r1>0 && r2>0){
			map.put("flag", "true");
		}else{
			map.put("flag", "false");
		}
		Gson gson = new Gson();
		String json = gson.toJson(map);
		System.out.println(json);
		return json;
	}
	
	
	/**
	 * 处理生成出租单应付金额和预付金
	 * @param req
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping("addRentDataHandler")
	@ResponseBody
	public String addRentDataHandler(HttpServletRequest req) throws ParseException{
		String rentStartTime = req.getParameter("rentStartTime");
		String rentEndTime = req.getParameter("rentEndTime");
		String rentPrice = req.getParameter("rentPrice");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date t1 = sdf.parse(rentStartTime);
		java.util.Date t2 = sdf.parse(rentEndTime);
		int day = (int) ((t2.getTime() - t1.getTime()) / (24*60*60*1000));
		double priceShouldPay = Double.parseDouble(rentPrice)*day;
		double imprestNeed =Double.parseDouble(rentPrice)*11;
		
		Map<String,Double> map = new HashMap<String,Double>();
		map.put("priceShouldPay", priceShouldPay);
		map.put("imprestNeed", imprestNeed);
		Gson gson  = new Gson();
		String json = gson.toJson(map);
		System.out.println(json);
		return json;
		
		/*List<Double> list = new ArrayList<Double>();
		list.add(priceShouldPay);
		list.add(imprestNeed);
		Gson gson  = new Gson();
		String json = gson.toJson(list);
		return json;*/
	}
	
	/**
	 * 增加出租单
	 * @param rentTable
	 * @return
	 */
	@RequestMapping("addRentTable")
	public String addRentTable(RentTable rentTable) {
		int r1 = rentTableService.addRentTable(rentTable);
		Map<String, String> map = new HashMap();
		map.put("carNumber", rentTable.getCarNumber());
		map.put("flag", "1");
		int r2 = carService.changeFlagByNumber(map);
		if(r1>0 && r2>0){
			return "success";
		}
		return "error";
	}
	
	/**
	 * 添加出租单前数据处理
	 * @param req
	 * @return
	 */
	@RequestMapping("preAddRentTable")
	public String preAddRentTable(HttpServletRequest req){
		//提供添加出租单需要的数据
		req.setAttribute("carid", req.getParameter("carid"));
		req.setAttribute("carNumber", req.getParameter("carNumber"));
		req.setAttribute("custIdentity", req.getParameter("custIdentity"));
		req.setAttribute("custId", req.getParameter("custId"));
		req.setAttribute("rentPrice", req.getParameter("rentPrice"));
		req.setAttribute("rentTableNo", new java.util.Date().getTime());
		//req.setAttribute("rentTableNo", UUID.randomUUID().toString().replace("-", ""));
		return "addRentCarTable";
	}
	
	@RequestMapping("findRentTable")
	public String findRentTable(){
		return "findRentTable";
	}
	
	/**
	 * 根据条件查询出租单
	 * @param req
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping("findRentTableHandler")
	public String findRentTable(HttpServletRequest req) throws ParseException {
		//获取前台数据
		String rentno = req.getParameter("rentNo")=="" ? null : req.getParameter("rentNo");
		String realEndTime  = req.getParameter("realEndTime");
		String beginTime = req.getParameter("beginTime");
		String endTime = req.getParameter("endTime");
		String rentFlag = req.getParameter("rentFlag");
		String userName = req.getParameter("username")=="" ? null : req.getParameter("username");
		String carNumber = req.getParameter("carNumber")=="" ? null : req.getParameter("carNumber");
		String custIdentity = req.getParameter("custIdentity")=="" ? null :req.getParameter("custIdentity");
		
		//对前台数据进行处理，准备好查询数据
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date ret = null;
		Date bt = null;
		Date et = null;
		if( realEndTime!=null && realEndTime!="" ){
			ret = new Date(sdf.parse(realEndTime).getTime());
		}
		if( beginTime!=null && beginTime!="" ){
			bt = new Date(sdf.parse(beginTime).getTime());
		}
		if( endTime!=null && endTime!="" ){
			et = new Date(sdf.parse(endTime).getTime());
		}
		RentTable rentTable = new RentTable();
		rentTable.setRentNo(rentno);
		rentTable.setRealEndTime(ret);
		rentTable.setBeginTime(bt);
		rentTable.setEndTime(et);
		if(!"-1".equals(rentFlag)){
			rentTable.setRentFlag(rentFlag);
		}
		rentTable.setUserName(userName);
		rentTable.setCarNumber(carNumber);
		rentTable.setCustIdentity(custIdentity);
		System.out.println(rentTable);
		List<RentTable> tables = rentTableService.findRenttables(rentTable);
		System.out.println(tables);
		if(tables.size()>0){
			req.setAttribute("tables", tables);
			return "listRentTable";
		}
		return "nothing";
	}
	
	@RequestMapping("findRentableByRentNo")
	@ResponseBody
	public String findCustByCard(HttpServletRequest req){
		String rentNo = req.getParameter("rentNo");
		RentTable rentTable =  rentTableService.findRentableByRentNo(rentNo);
		
		Map map = new HashMap();
		if(rentTable!=null){
			map.put("rentNo", rentTable.getRentNo());
			map.put("flag", "ok");
			if(!"1".equals(rentTable.getRentFlag())){
				map.put("flag", "err_no");
			}
		}else{
			map.put("flag", "false");
		}
		Gson gson = new Gson();
		String json = gson.toJson(map);
		return json;
	}
	

}
