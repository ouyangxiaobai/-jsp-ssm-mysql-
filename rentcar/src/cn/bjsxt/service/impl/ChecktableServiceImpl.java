package cn.bjsxt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bjsxt.mapper.CarMapper;
import cn.bjsxt.mapper.ChecktableMapper;
import cn.bjsxt.mapper.RentTableMapper;
import cn.bjsxt.pojo.Checktable;
import cn.bjsxt.pojo.RentTable;
import cn.bjsxt.service.ChecktableService;
@Service
public class ChecktableServiceImpl implements ChecktableService {
	@Autowired
	ChecktableMapper checktableMapper;
	@Autowired
	CarMapper carMapper;
	@Autowired
	RentTableMapper rentTableMapper;

	@Override
	public int addChecktable(Checktable checktable, RentTable rentTable) {
		int row = checktableMapper.addChecktable(checktable);
		if (row > 0) {
			int row2 = carMapper.updateRentFlagByNo(rentTable.getCarNumber());
			int row3 = rentTableMapper.updateFlagById(rentTable.getRentid(),checktable.getChecktime());
			row = row *row2*row3;
		}
		return row;
	}

	@Override
	public List<Checktable> findChecktable(Checktable checktable) {
		return checktableMapper.findChecktable(checktable);
	}

	@Override
	public Checktable findChecktableById(String checkid) {
		return checktableMapper.findChecktableById(checkid);
	}

	@Override
	public int updateChecktable(Checktable checktable) {
		return checktableMapper.updateChecktable(checktable);
	}
}
