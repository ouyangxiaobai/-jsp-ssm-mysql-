package cn.bjsxt.service;

import cn.bjsxt.pojo.Loginlog;
import cn.bjsxt.pojo.Logtable;
import cn.bjsxt.utils.MyPageBean;

public interface LogtableService {

	int addLogtable(Logtable logtable);

	void findLoginlog(MyPageBean<Loginlog> mpb, String name);

	void findLogtable(MyPageBean<Logtable> mpb, String name);
}
