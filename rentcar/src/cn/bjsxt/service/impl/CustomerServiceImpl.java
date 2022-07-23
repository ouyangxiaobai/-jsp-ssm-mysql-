package cn.bjsxt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bjsxt.mapper.CustomerMapper;
import cn.bjsxt.pojo.Customer;
import cn.bjsxt.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerMapper customerMapper;
	@Override
	public List<Customer> findAll() {
		return customerMapper.selectAll();
	}
	
	@Override
	public Customer login(String name, String pwd) {
		return customerMapper.login(name, pwd);
	}
	
	@Override
	public int deleteById(int id) {
		return customerMapper.deleteById(id);
	}
	@Override
	public int addCustomer(Customer customer) {
		return customerMapper.addCustomer(customer);
	}
	@Override
	public int updateCustomer(Customer customer) {
		return customerMapper.updateCustomer(customer);
	}

	@Override
	public List<Customer> findCusts(String name,String identity) {
		// TODO Auto-generated method stub
		return customerMapper.selectCusts(name,identity);
	}


	@Override
	public int deleteCustomer(int custId) {
		// TODO Auto-generated method stub
		return customerMapper.deleteCustomer(custId);
	}

	@Override
	public Customer findCustByCard(String identity) {
		return customerMapper.findCustByCard(identity);
	}

	@Override
	public Customer findCustomerByIdentity(String custIdentity) {
		return customerMapper.findCustomerByIdentity(custIdentity);
	}


}
