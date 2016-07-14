package com.soecode.xfshxzs.po.one;

/**
 * 一个实体
 */
public class One {

	// VOL编号
	private String vol;

	// 日期
	private String date;

	// 图片
	private Picture picture;

	// 文章
	private Article article;

	// 问答
	private Question question;

	// 音乐
	private Music music;

	public String getVol() {
		return vol;
	}

	public void setVol(String vol) {
		this.vol = vol;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Picture getPicture() {
		return picture;
	}

	public void setPicture(Picture picture) {
		this.picture = picture;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Music getMusic() {
		return music;
	}

	public void setMusic(Music music) {
		this.music = music;
	}

	@Override
	public String toString() {
		return "One [vol=" + vol + ", date=" + date + ", picture=" + picture + ", article=" + article + ", question="
				+ question + ", music=" + music + "]";
	}

}
