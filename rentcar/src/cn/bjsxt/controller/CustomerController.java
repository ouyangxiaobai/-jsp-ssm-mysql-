package cn.bjsxt.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import cn.bjsxt.pojo.Customer;
import cn.bjsxt.pojo.User;
import cn.bjsxt.service.CustomerService;
import cn.bjsxt.service.UserService;
import cn.bjsxt.utils.Md5Util;

@Controller
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@RequestMapping("findCustByCard")
	@ResponseBody
	public String findCustByCard(HttpServletRequest req){
		String identity = req.getParameter("identity");
		Customer cust =  customerService.findCustByCard(identity);
		Map map = new HashMap();
		if(cust!=null){
			map.put("custid", cust.getCustId());
			map.put("identity", cust.getIdentity());
			map.put("flag", "ok");
		}else{
			map.put("flag", "false");
		}
		Gson gson = new Gson();
		String json = gson.toJson(map);
		return json;
	}
	

	@RequestMapping("searchCust")
	public String findCust() {
		return "searchCust";
	}
	
	@RequestMapping("addCust")
	public String addCust() {
		return "addCust";
	}
	
	@RequestMapping("findAll")
	@ResponseBody
	public String findAll() {
		// 从业务层拿到数据
		List<Customer> list = customerService.findAll();
		// 将数据转换成json
		Gson gson = new Gson();
		// 使用gson将集合转换成json串
		String json = gson.toJson(list);
		return json;
	}
	
	@RequestMapping("findCusts")
	@ResponseBody
	public String findCusts(HttpServletRequest req) {
		
		String name = req.getParameter("name");
		String identity = req.getParameter("identity");
		
		// 从业务层拿到数据
		List<Customer> list = customerService.findCusts(name,identity);
		// 将数据转换成json
		Gson gson = new Gson();
		// 使用gson将集合转换成json串
		String json = gson.toJson(list);
		return json;
	}

	@RequestMapping("insertCustomer")
	@ResponseBody
	public String insertCustomer(Customer customer) {
		Map map = new HashMap<>();
		if (customerService.addCustomer(customer) > 0) {
			map.put("flag", "ok");
		} else {
			map.put("flag", "ng");
		}
		Gson gson = new Gson();
		String sgson = gson.toJson(map);
		return sgson;
	}


	@RequestMapping("updateCustomer")
	public String updateCustomer(Customer customer, HttpServletRequest request) {
		int custId = Integer.parseInt(request.getParameter("custId"));
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		Character sex = request.getParameter("sex").toCharArray()[0];
		String identity = request.getParameter("identity");
		String phone = request.getParameter("phone");
		String career = request.getParameter("career");
		String address = request.getParameter("address");
		customer = new Customer(custId, name, pwd,sex, identity, phone, career,address);

		if (customerService.updateCustomer(customer) > 0) {
			return "list";
		} else {
			return "error";
		}
	}
	
	@RequestMapping("deleteCustomer")
	public String deleteCustomer(int custId, HttpServletRequest request) {
		
		System.out.println("删除客户操作："+(customerService.deleteCustomer(custId) > 0));
		if (customerService.deleteCustomer(custId) > 0) {
			return "ok";
		} else {
			return "error";
		}
	}

}
