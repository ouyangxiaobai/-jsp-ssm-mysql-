package cn.bjsxt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bjsxt.mapper.LogtableMapper;
import cn.bjsxt.pojo.Loginlog;
import cn.bjsxt.pojo.Logtable;
import cn.bjsxt.service.LogtableService;
import cn.bjsxt.utils.MyPageBean;
@Service
public class LogtableServiceImpl implements LogtableService {
	@Autowired
	LogtableMapper logtableMapper;

	@Override
	public int addLogtable(Logtable logtable) {
		return logtableMapper.addLogtable(logtable);
	}
	
	@Override
	public void findLoginlog(MyPageBean<Loginlog> mpb, String name) {
		int startRow = mpb.getStartRow();
		int size = mpb.getSize();
		int totalCount = logtableMapper.findLoginlogTotalCount(name);
		mpb.setTotalCount(totalCount);
		List<Loginlog> list = logtableMapper.findLoginlog(startRow,size,name);
		mpb.setList(list);
	}
	

	@Override
	public void findLogtable(MyPageBean<Logtable> mpb, String name) {
		int startRow = mpb.getStartRow();
		int size = mpb.getSize();
		int totalCount = logtableMapper.findLogtableTotalCount(name);
		mpb.setTotalCount(totalCount);
		List<Logtable> list = logtableMapper.findLogtable(startRow,size,name);
		mpb.setList(list);
		
	}

	
}
