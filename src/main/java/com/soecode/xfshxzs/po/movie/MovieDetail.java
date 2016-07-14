package com.soecode.xfshxzs.po.movie;

import java.util.List;

/**
 * 电影详细结果实体
 */
public class MovieDetail {

	// 电影ID
	private String id;

	// 电影名
	private String title;

	// 首页封面URL
	private String indexcover;

	// 主题封面URL
	private String detailcover;

	// 视频URL
	private String video;

	private String verse;

	private String verse_en;

	// 评分
	private int score;

	private int revisedscore;

	// 用户评分数据
	private String review;

	// 关键字;分割
	private String keywords;

	private String movie_id;

	// 影片信息（导演、编剧、主演、类型、制片国家/地区）
	private String info;

	// 官方情节
	private String officialstory;

	// 责任编辑
	private String charge_edt;

	// WEB主页URL
	private String web_url;

	// 点赞数
	private int praisenum;

	private String sort;

	private String releasetime;

	private String scoretime;

	private String maketime;

	// 最后更新时间
	private String last_update_date;

	// 阅读数
	private String read_num;

	// 官方剧照
	private List<String> photo;

	// 分享数
	private String sharenum;

	// 评论数
	private String commentnum;

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

	public String getIndexcover() {
		return indexcover;
	}

	public void setIndexcover(String indexcover) {
		this.indexcover = indexcover;
	}

	public String getDetailcover() {
		return detailcover;
	}

	public void setDetailcover(String detailcover) {
		this.detailcover = detailcover;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
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

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getMovie_id() {
		return movie_id;
	}

	public void setMovie_id(String movie_id) {
		this.movie_id = movie_id;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getOfficialstory() {
		return officialstory;
	}

	public void setOfficialstory(String officialstory) {
		this.officialstory = officialstory;
	}

	public String getCharge_edt() {
		return charge_edt;
	}

	public void setCharge_edt(String charge_edt) {
		this.charge_edt = charge_edt;
	}

	public String getWeb_url() {
		return web_url;
	}

	public void setWeb_url(String web_url) {
		this.web_url = web_url;
	}

	public int getPraisenum() {
		return praisenum;
	}

	public void setPraisenum(int praisenum) {
		this.praisenum = praisenum;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
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

	public String getMaketime() {
		return maketime;
	}

	public void setMaketime(String maketime) {
		this.maketime = maketime;
	}

	public String getLast_update_date() {
		return last_update_date;
	}

	public void setLast_update_date(String last_update_date) {
		this.last_update_date = last_update_date;
	}

	public String getRead_num() {
		return read_num;
	}

	public void setRead_num(String read_num) {
		this.read_num = read_num;
	}

	public List<String> getPhoto() {
		return photo;
	}

	public void setPhoto(List<String> photo) {
		this.photo = photo;
	}

	public String getSharenum() {
		return sharenum;
	}

	public void setSharenum(String sharenum) {
		this.sharenum = sharenum;
	}

	public String getCommentnum() {
		return commentnum;
	}

	public void setCommentnum(String commentnum) {
		this.commentnum = commentnum;
	}

	public String getServertime() {
		return servertime;
	}

	public void setServertime(String servertime) {
		this.servertime = servertime;
	}

	@Override
	public String toString() {
		return "MovieDetail [id=" + id + ", title=" + title + ", indexcover=" + indexcover + ", detailcover="
				+ detailcover + ", video=" + video + ", verse=" + verse + ", verse_en=" + verse_en + ", score=" + score
				+ ", revisedscore=" + revisedscore + ", review=" + review + ", keywords=" + keywords + ", movie_id="
				+ movie_id + ", info=" + info + ", officialstory=" + officialstory + ", charge_edt=" + charge_edt
				+ ", web_url=" + web_url + ", praisenum=" + praisenum + ", sort=" + sort + ", releasetime="
				+ releasetime + ", scoretime=" + scoretime + ", maketime=" + maketime + ", last_update_date="
				+ last_update_date + ", read_num=" + read_num + ", photo=" + photo + ", sharenum=" + sharenum
				+ ", commentnum=" + commentnum + ", servertime=" + servertime + "]";
	}

}
