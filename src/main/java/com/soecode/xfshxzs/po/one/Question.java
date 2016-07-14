package com.soecode.xfshxzs.po.one;

/**
 * 问答实体
 */
public class Question {

	// 问答ID
	private String id;

	// 问题
	private String title;

	// WEB地址
	private String web_url;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWeb_url() {
		return web_url;
	}

	public void setWeb_url(String web_url) {
		this.web_url = web_url;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", title=" + title + ", web_url=" + web_url + "]";
	}

}
