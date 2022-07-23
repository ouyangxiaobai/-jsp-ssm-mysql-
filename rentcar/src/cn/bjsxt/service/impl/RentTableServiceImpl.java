package cn.bjsxt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bjsxt.mapper.RentTableMapper;
import cn.bjsxt.mapper.UserMapper;
import cn.bjsxt.pojo.Customer;
import cn.bjsxt.pojo.RentTable;
import cn.bjsxt.pojo.User;
import cn.bjsxt.service.RenttableService;

@Service
public class RentTableServiceImpl implements RenttableService  {
	@Autowired
	RentTableMapper rentTableMapper;

	@Override
	public List<RentTable> findRenttables(RentTable renttable) {
		
		return rentTableMapper.findRenttables(renttable);
	}

	@Override
	public Customer getCustById(int cid) {
		return rentTableMapper.getCustById(cid);
	}

	@Override
	public User getUserById(int uid) {
		return rentTableMapper.getUserById(uid);
	}

	@Override
	public int addRentTable(RentTable rentTable) {
		return rentTableMapper.addRentTable(rentTable);
	}

	@Override
	public int dropRentTable(int rentTableId) {
		return rentTableMapper.changeRentFlag(rentTableId);
	}

	@Override
	public RentTable findTableById(int rentId) {
		return rentTableMapper.findTableById(rentId);
	}

	@Override
	public RentTable getTableById(int rentTableId) {
		return rentTableMapper.getTableById(rentTableId);
	}

	@Override
	public int updateRentTable(RentTable table) {
		return rentTableMapper.updateRentTable(table);
	}

	@Override
	public RentTable findRentableByRentNo(String rentNo) {
		return rentTableMapper.findRentableByRentNo(rentNo);
	}

	@Override
	public List<RentTable> findRentableByEndTime(String endTime) {
		return rentTableMapper.findRentableByEndTime(endTime);
	}

	


}
