package com.ec.formflood.util;

import com.ec.formflood.random.RAdderss;
import com.ec.formflood.random.RComment;
import com.ec.formflood.random.RName;
import com.ec.formflood.random.RTelephone;

public interface RandomUtil {

	RName getName();

	RTelephone getTelephone();

	RAdderss getAddress();

	RComment getComment();

}
