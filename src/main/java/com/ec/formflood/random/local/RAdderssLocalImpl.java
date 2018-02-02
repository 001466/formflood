package com.ec.formflood.random.local;

import org.springframework.stereotype.Component;

import com.ec.formflood.random.RAdderss;
@Component("rAdderssLocalImpl")
public class RAdderssLocalImpl extends RAdderss{

	@Override
	public AdderssEntity random() {
		return new AdderssEntity("广东","怀集","冷坑","爱三");
	}

}
