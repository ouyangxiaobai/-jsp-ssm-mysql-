package cn.bjsxt.service;

import java.util.List;

import cn.bjsxt.pojo.Customer;
import cn.bjsxt.pojo.RentTable;
import cn.bjsxt.pojo.User;

public interface RenttableService {

	/**
	 * 查询所有出租单信息
	 * 
	 * @return
	 */

	List<RentTable> findRenttables(RentTable Renttable);

	Customer getCustById(int cid);

	User getUserById(int uid);

	public int addRentTable(RentTable rentTable);

	int dropRentTable(int rentTableId);

	RentTable findTableById(int rentId);

	RentTable getTableById(int rentTableId);

	int updateRentTable(RentTable table);

	RentTable findRentableByRentNo(String rentNo);

	List<RentTable> findRentableByEndTime(String endTime);

}
