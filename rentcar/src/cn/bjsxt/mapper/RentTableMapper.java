package cn.bjsxt.mapper;

import java.util.List;

import cn.bjsxt.pojo.Customer;
import cn.bjsxt.pojo.RentTable;
import cn.bjsxt.pojo.User;

public interface RentTableMapper {

	/**
	 * 查询方法
	 * @param username
	 * @param userpwd
	 * @return
	 */
	List<RentTable> findRenttables(RentTable renttable);

	Customer getCustById(int cid);

	User getUserById(int uid);

	public int addRentTable(RentTable rentTable);

	int changeRentFlag(int rentTableId);

	RentTable findTableById(int rentId);

	RentTable getTableById(int rentTableId);

	int updateRentTable(RentTable table);

	RentTable findRentableByRentNo(String rentNo);

	int updateFlagById(int rentid, String string);

	List<RentTable> findRentableByEndTime(String endTime);
}
