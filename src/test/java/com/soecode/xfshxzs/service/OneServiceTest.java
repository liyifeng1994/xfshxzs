package com.soecode.xfshxzs.service;

import org.junit.Test;

import com.soecode.xfshxzs.po.one.One;
import com.soecode.xfshxzs.service.OneService;

public class OneServiceTest {

	OneService oneService = new OneService();

	@Test
	public void testGetOne() {
		One one = oneService.getOne();
		System.out.println(one.getVol());
		System.out.println(one.getDate());
		System.out.println(one.getPicture());
		System.out.println(one.getArticle());
		System.out.println(one.getQuestion());
		System.out.println(one.getMusic());
	}

}
