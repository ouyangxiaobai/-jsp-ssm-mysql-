package cn.bjsxt.service;

import java.util.List;

import cn.bjsxt.pojo.Checktable;
import cn.bjsxt.pojo.RentTable;

public interface ChecktableService {

	int addChecktable(Checktable checktable, RentTable rentTable);

	List<Checktable> findChecktable(Checktable checktable);

	Checktable findChecktableById(String checkid);

	int updateChecktable(Checktable checktable);
	
}
