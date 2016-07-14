package com.soecode.xfshxzs.po.movie;

/**
 * 电影实体
 */
public class Movie {

	// 电影ID
	private String id;

	// 电影名
	private String title;

	private String verse;

	private String verse_en;

	// 评分
	private int score;

	private int revisedscore;

	private String releasetime;

	private String scoretime;

	// 首页封面URL
	private String cover;

	private String servertime;

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

	public String getVerse() {
		return verse;
	}

	public void setVerse(String verse) {
		this.verse = verse;
	}

	public String getVerse_en() {
		return verse_en;
	}

	public void setVerse_en(String verse_en) {
		this.verse_en = verse_en;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getRevisedscore() {
		return revisedscore;
	}

	public void setRevisedscore(int revisedscore) {
		this.revisedscore = revisedscore;
	}

	public String getReleasetime() {
		return releasetime;
	}

	public void setReleasetime(String releasetime) {
		this.releasetime = releasetime;
	}

	public String getScoretime() {
		return scoretime;
	}

	public void setScoretime(String scoretime) {
		this.scoretime = scoretime;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public String getServertime() {
		return servertime;
	}

	public void setServertime(String servertime) {
		this.servertime = servertime;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", verse=" + verse + ", verse_en=" + verse_en + ", score="
				+ score + ", revisedscore=" + revisedscore + ", releasetime=" + releasetime + ", scoretime=" + scoretime
				+ ", cover=" + cover + ", servertime=" + servertime + "]";
	}

}
