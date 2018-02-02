package com.ec.formflood.util.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ec.formflood.random.RAdderss;
import com.ec.formflood.random.RComment;
import com.ec.formflood.random.RName;
import com.ec.formflood.random.RTelephone;
import com.ec.formflood.util.RandomUtil;

@Component
public class RandomUtilLocalImpl implements RandomUtil{

	
	@Autowired
	protected RName name;
	@Autowired
	protected RTelephone telephone;
	@Autowired
	protected RAdderss address;
	@Autowired
	protected RComment comment;
	
	@Override
	public RName getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public RTelephone getTelephone() {
		// TODO Auto-generated method stub
		return telephone;
	}

	@Override
	public RAdderss getAddress() {
		// TODO Auto-generated method stub
		return address;
	}

	@Override
	public RComment getComment() {
		// TODO Auto-generated method stub
		return comment;
	}

}
