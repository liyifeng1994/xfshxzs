package com.soecode.xfshxzs.po.one;

/**
 * 文章实体
 */
public class Article {

	// 文章ID
	private String id;

	// 标题
	private String title;

	// 作者
	private String author;

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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getWeb_url() {
		return web_url;
	}

	public void setWeb_url(String web_url) {
		this.web_url = web_url;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", author=" + author + ", web_url=" + web_url + "]";
	}

}
