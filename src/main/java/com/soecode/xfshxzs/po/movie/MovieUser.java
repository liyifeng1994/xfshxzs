package com.soecode.xfshxzs.po.movie;

/**
 * 电影用户实体
 */
public class MovieUser {

	// 用户ID
	private String user_id;

	// 用户名
	private String user_name;

	// 头像URL
	private String web_url;

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getWeb_url() {
		return web_url;
	}

	public void setWeb_url(String web_url) {
		this.web_url = web_url;
	}

	@Override
	public String toString() {
		return "MovieUser [user_id=" + user_id + ", user_name=" + user_name + ", web_url=" + web_url + "]";
	}

}
