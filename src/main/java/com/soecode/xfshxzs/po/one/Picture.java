package com.soecode.xfshxzs.po.one;

/**
 * 图片实体
 */
public class Picture {

	// 图片ID
	private String id;

	// 内容描述
	private String content;

	// 图片地址
	private String image_url;

	// WEB地址
	private String web_url;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	public String getWeb_url() {
		return web_url;
	}

	public void setWeb_url(String web_url) {
		this.web_url = web_url;
	}

	@Override
	public String toString() {
		return "Picture [id=" + id + ", content=" + content + ", image_url=" + image_url + ", web_url=" + web_url + "]";
	}

}
