package cn.bjsxt.service;

import cn.bjsxt.pojo.Customer;

import java.util.List;

public interface CustomerService {
	/**
	 * 查询所有客户信息
	 * 
	 * @return
	 */
	List<Customer> findAll();

	/**
	 * 客户登录方法
	 * 
	 * @param name
	 * @param pwd
	 * @return
	 */
	Customer login(String name, String pwd);

	/**
	 * 删除方法
	 * 
	 * @param id
	 * @return
	 */
	int deleteById(int id);

	/**
	 * 添加新客户
	 * 
	 * @param customer
	 * @return
	 */
	int addCustomer(Customer customer);

	
	
	/**
	 * 修改客户信息方法
	 * 
	 * @param customer
	 * @return
	 */
	int updateCustomer(Customer customer);

	List<Customer> findCusts(String name,String identity);

	int deleteCustomer(int custId);

	public Customer findCustByCard(String identity);

	Customer findCustomerByIdentity(String custIdentity);
}
