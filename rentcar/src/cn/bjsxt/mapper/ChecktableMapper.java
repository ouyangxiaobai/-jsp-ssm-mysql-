package cn.bjsxt.mapper;

import java.util.List;

import cn.bjsxt.pojo.Checktable;

public interface ChecktableMapper {

	int addChecktable(Checktable checktable);

	List<Checktable> findChecktable(Checktable checktable);

	Checktable findChecktableById(String checkid);

	int updateChecktable(Checktable checktable);

}
