package com.soecode.xfshxzs.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

import com.soecode.xfshxzs.po.movie.Movie;
import com.soecode.xfshxzs.po.movie.MovieCommentResult;
import com.soecode.xfshxzs.po.movie.MovieDetail;
import com.soecode.xfshxzs.po.movie.MovieStoryResult;
import com.soecode.xfshxzs.util.HttpUitl;

/**
 * 电影业务
 * 
 * {@link http://m.wufazhuce.com/apps} 一个APP
 */
public class MovieService {

	// 电影列表URL
	private static final String MOVIE_LIST_URL = "http://v3.wufazhuce.com:8000/api/movie/list/0";

	// 电影详情
	private static final String MOVIE_DETAIL_URL = "http://v3.wufazhuce.com:8000/api/movie/detail/ID";

	// 电影故事（首个）
	private static final String MOVIE_FIRST_STORY_URL = "http://v3.wufazhuce.com:8000/api/movie/ID/story/1/0";

	// 全部剧情
	private static final String MOVIE_ALL_STORY_URL = "http://v3.wufazhuce.com:8000/api/movie/ID/story/0/0";

	// 评论列表（热门 点赞）
	private static final String MOVIE_PRAISE_COMMENT_URL = "http://v3.wufazhuce.com:8000/api/comment/praise/movie/ID/0";

	// 全部评论（最新）
	private static final String MOVIE_TIME_COMMENT_URL = "http://v3.wufazhuce.com:8000/api/comment/time/movie/ID/0";

	/**
	 * 获取电影列表
	 * 
	 * @return
	 */
	public List<Movie> getMovieList() {
		List<Movie> list = new ArrayList<Movie>();
		try {
			String json = HttpUitl.doGet(MOVIE_LIST_URL);
			ObjectMapper mapper = new ObjectMapper();
			JsonNode root = mapper.readTree(json);
			JsonNode data = root.path("data");
			if (data.isArray()) {
				for (JsonNode node : data) {
					Movie movie = mapper.readValue(node, Movie.class);
					list.add(movie);
				}
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 获取电影详细
	 * 
	 * @param id
	 * @return
	 */
	public MovieDetail getMovieDetailById(String id) {
		MovieDetail movieDetail = null;
		try {
			String json = HttpUitl.doGet(MOVIE_DETAIL_URL.replace("ID", id));
			ObjectMapper mapper = new ObjectMapper();
			JsonNode root = mapper.readTree(json);
			JsonNode data = root.path("data");
			movieDetail = mapper.readValue(data, MovieDetail.class);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return movieDetail;
	}

	/**
	 * 获取电影URL
	 * 
	 * @param id
	 * @return
	 */
	public String getMovieURLById(String id) {
		return getMovieDetailById(id).getWeb_url();
	}

	/**
	 * 获取电影故事
	 * 
	 * @param type
	 * @param id
	 * @return
	 */
	public MovieStoryResult getMovieStoryById(String type, String id) {
		String url = null;
		if ("all".equals(type)) {// 全部
			url = MOVIE_ALL_STORY_URL;
		} else {// 首个
			url = MOVIE_FIRST_STORY_URL;
		}
		MovieStoryResult movieStoryResult = null;
		try {
			String json = HttpUitl.doGet(url.replace("ID", id));
			ObjectMapper mapper = new ObjectMapper();
			JsonNode root = mapper.readTree(json);
			JsonNode data = root.path("data");
			movieStoryResult = mapper.readValue(data, MovieStoryResult.class);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return movieStoryResult;
	}

	/**
	 * 获取电影评论
	 * 
	 * @param type
	 * @param id
	 * @return
	 */
	public MovieCommentResult getMovieCommentById(String type, String id) {
		String url = null;
		if ("time".equals(type)) {// 最新
			url = MOVIE_TIME_COMMENT_URL;
		} else {// 热门
			url = MOVIE_PRAISE_COMMENT_URL;
		}
		MovieCommentResult movieCommentResult = null;
		try {
			String json = HttpUitl.doGet(url.replace("ID", id));
			ObjectMapper mapper = new ObjectMapper();
			JsonNode root = mapper.readTree(json);
			JsonNode data = root.path("data");
			movieCommentResult = mapper.readValue(data, MovieCommentResult.class);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return movieCommentResult;
	}

}
