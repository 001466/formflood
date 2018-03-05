package com.ec.formflood.random.local;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import com.ec.formflood.random.RComment;
@Component("rCommentLocalImpl")
public class RCommentLocalImpl implements RComment,InitializingBean{

	List<String> commentPools=new ArrayList<>();
	java.util.Random random=new Random(50);
	private static int strategyIndex = 0;
	
	@Override
	public String random() {
		strategyIndex =  random.nextInt()% commentPools.size();
		return commentPools.get(strategyIndex);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		commentPools.add("");
		commentPools.add("尽快发货");
		commentPools.add("请尽快发货");
		commentPools.add("");
		
		commentPools.add("");
		commentPools.add("");
		commentPools.add("");
		commentPools.add("");
		commentPools.add("");
		commentPools.add("");
		commentPools.add("");
		commentPools.add("尽快发货！");
		commentPools.add("");
		commentPools.add("");
		commentPools.add("");
		commentPools.add("");
		commentPools.add("");
		commentPools.add("");
		commentPools.add("");
		
		commentPools.add("阿尼陀佛");
		commentPools.add("");
		commentPools.add("");
		commentPools.add("");
		
	}

}
