package com.soecode.xfshxzs.service;

import org.junit.Test;

import com.soecode.xfshxzs.po.express.Express;
import com.soecode.xfshxzs.service.ExpressService;

public class ExpressServiceTest {
	
	ExpressService expressService = new ExpressService();

	@Test
	public void testGetExpressByPostId() {
		Express express = expressService.getExpressByPostId("20146073240");
		System.out.println(express);
		System.out.println(express.getUrl());
	}

}
