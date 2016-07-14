package com.soecode.xfshxzs.po.movie;

/**
 * 电影评论实体
 */
public class MovieComment {

	// 评论ID
	private String id;

	// 引用内容
	private String quote;

	// 评论内容
	private String content;

	// 点赞数
	private int praisenum;

	// 发表时间
	private String input_date;

	// 评论者
	private MovieUser user;

	// 被引用者
	private MovieUser touser;

	// 评分
	private int score;

	// 类型
	private int tyoe;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getQuote() {
		return quote;
	}

	public void setQuote(String quote) {
		this.quote = quote;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getPraisenum() {
		return praisenum;
	}

	public void setPraisenum(int praisenum) {
		this.praisenum = praisenum;
	}

	public String getInput_date() {
		return input_date;
	}

	public void setInput_date(String input_date) {
		this.input_date = input_date;
	}

	public MovieUser getUser() {
		return user;
	}

	public void setUser(MovieUser user) {
		this.user = user;
	}

	public MovieUser getTouser() {
		return touser;
	}

	public void setTouser(MovieUser touser) {
		this.touser = touser;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getTyoe() {
		return tyoe;
	}

	public void setTyoe(int tyoe) {
		this.tyoe = tyoe;
	}

	@Override
	public String toString() {
		return "MovieComment [id=" + id + ", quote=" + quote + ", content=" + content + ", praisenum=" + praisenum
				+ ", input_date=" + input_date + ", user=" + user + ", touser=" + touser + ", score=" + score
				+ ", tyoe=" + tyoe + "]";
	}

}
