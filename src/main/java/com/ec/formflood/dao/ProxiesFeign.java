package com.ec.formflood.dao;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ec.common.model.Response;
import com.ec.formflood.random.RProxy;

@FeignClient(name = "proxy")
public interface ProxiesFeign {
	@RequestMapping("/get/{protl}")
	public Response<RProxy.ProxyEntity> get(@RequestParam("protl") String protl);
}
