package com.soecode.xfshxzs.po.one;

/**
 * 音乐实体
 */
public class Music {

	// 音乐ID
	private String id;

	// 音乐名称
	private String title;

	// 封面URL
	private String cover;

	// WEB地址
	private String web_url;

	// 作者信息
	private String author;

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

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public String getWeb_url() {
		return web_url;
	}

	public void setWeb_url(String web_url) {
		this.web_url = web_url;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Music [id=" + id + ", title=" + title + ", cover=" + cover + ", web_url=" + web_url + ", author="
				+ author + "]";
	}

}
