package com.ec.formflood.random.local;

import org.springframework.stereotype.Component;

import com.ec.formflood.random.RDeliver;

@Component("rDeliverLocalImpl")

public class RDeliverLocalImpl implements RDeliver{

	@Override
	public DeliverEntity random() {
		return new DeliverEntity("随时可以联系我","","");
	}

}
