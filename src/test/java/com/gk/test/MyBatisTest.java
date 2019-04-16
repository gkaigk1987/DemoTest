package com.gk.test;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.gk.mapper.OrderStartMapper;
import com.gk.util.MyBatisUtil;

public class MyBatisTest {
	
	@Test
	public void test001() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		OrderStartMapper orderStartMapper = sqlSession.getMapper(OrderStartMapper.class);
		List<Map<String,Object>> list = orderStartMapper.getOrderInfoList();
		System.out.println(list.size());
		sqlSession.close();
	}

}
