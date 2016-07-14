package com.soecode.xfshxzs.po.movie;

/**
 * 电影故事实体
 */
public class MovieStory {

	// 故事ID
	private String id;

	// 电影ID
	private String movie_id;

	// 标题
	private String title;

	// 内容
	private String content;

	// 用户ID
	private String user_id;

	private int sort;

	// 点赞数
	private int praisenum;

	// 最后更新时间
	private String input_date;

	private int story_type;

	// 用户
	private MovieUser user;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMovie_id() {
		return movie_id;
	}

	public void setMovie_id(String movie_id) {
		this.movie_id = movie_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
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

	public int getStory_type() {
		return story_type;
	}

	public void setStory_type(int story_type) {
		this.story_type = story_type;
	}

	public MovieUser getUser() {
		return user;
	}

	public void setUser(MovieUser user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "MovieStory [id=" + id + ", movie_id=" + movie_id + ", title=" + title + ", content=" + content
				+ ", user_id=" + user_id + ", sort=" + sort + ", praisenum=" + praisenum + ", input_date=" + input_date
				+ ", story_type=" + story_type + ", user=" + user + "]";
	}

}
