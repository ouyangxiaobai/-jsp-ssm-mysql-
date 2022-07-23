package cn.bjsxt.mapper;

import cn.bjsxt.pojo.Loginlog;
import cn.bjsxt.pojo.Logtable;

import java.util.List;

public interface LogtableMapper {

	int addLogtable(Logtable logtable);

	int findLoginlogTotalCount(String name);

	List<Loginlog> findLoginlog(int startRow, int size, String name);

	int findLogtableTotalCount(String name);

	List<Logtable> findLogtable(int startRow, int size, String name);
	

}
