package com.ec.formflood.random.local;

import org.springframework.stereotype.Component;

import com.ec.formflood.random.RComment;
@Component("rCommentLocalImpl")

public class RCommentLocalImpl implements RComment{

	@Override
	public String random() {
		// TODO Auto-generated method stub
		return "哈哈合";
	}

}
