package cn.bjsxt.mapper;

import java.util.List;

import cn.bjsxt.pojo.Customer;

public interface CustomerMapper {
	
	List<Customer> selectAll();

	/**
	 * 客户登录方法
	 * 
	 * @param name
	 * @param pwd
	 * @return
	 */
	Customer login(String name, String pwd);

	/**
	 * 删除客户方法
	 * 
	 * @param id
	 * @return
	 */
	int deleteById(int id);

	/**
	 * 添加客户
	 * 
	 * @param user
	 * @return
	 */
	int addCustomer(Customer customer);

	/**
	 * 修改方法
	 * 
	 * @param user
	 * @return
	 */
	 
	int updateCustomer(Customer customer);

	List<Customer> selectCusts(String name,String identity);

	int deleteCustomer(int custId);

	public Customer findCustByCard(String identity);

	Customer findCustomerByIdentity(String custIdentity);

}
