package com.soecode.xfshxzs.handler;

import java.util.List;
import java.util.Map;

import com.soecode.wxtools.api.WxMessageHandler;
import com.soecode.wxtools.api.WxService;
import com.soecode.wxtools.bean.WxXmlMessage;
import com.soecode.wxtools.bean.WxXmlOutMessage;
import com.soecode.wxtools.bean.WxXmlOutNewsMessage.Item;
import com.soecode.wxtools.bean.outxmlbuilder.NewsBuilder;
import com.soecode.wxtools.exception.WxErrorException;
import com.soecode.xfshxzs.po.movie.Movie;
import com.soecode.xfshxzs.po.movie.MovieDetail;
import com.soecode.xfshxzs.service.MovieService;

/**
 * 电影消息处理器
 */
public class MovieMessageHandler implements WxMessageHandler {

	private MovieService movieService = new MovieService();

	public WxXmlOutMessage handle(WxXmlMessage wxMessage, Map<String, Object> context, WxService wxService)
			throws WxErrorException {
		String content = wxMessage.getContent();
		NewsBuilder builder = WxXmlOutMessage.NEWS();
		if ("电影".equals(content)) {
			List<Movie> list = movieService.getMovieList();
			for (int i = 0; i < 7; i++) {
				MovieDetail movieDetail = movieService.getMovieDetailById(list.get(i).getId());
				Item item = new Item();
				item.setTitle(movieDetail.getScore() + "分 " + createStarsByScore(movieDetail.getScore()) + " | "
						+ movieDetail.getTitle());
				item.setPicUrl(movieDetail.getDetailcover());
				item.setUrl(movieDetail.getWeb_url());
				builder.addArticle(item);
			}
			Item item = new Item();
			item.setTitle("回复【更多】查看更多电影推荐");
			builder.addArticle(item);
		} else if ("更多".equals(content)) {
			List<Movie> list = movieService.getMovieList();
			for (int i = 7; i < 15; i++) {
				MovieDetail movieDetail = movieService.getMovieDetailById(list.get(i).getId());
				Item item = new Item();
				item.setTitle(movieDetail.getScore() + "分 " + createStarsByScore(movieDetail.getScore()) + " | "
						+ movieDetail.getTitle());
				item.setPicUrl(movieDetail.getDetailcover());
				item.setUrl(movieDetail.getWeb_url());
				builder.addArticle(item);
			}
		}
		return builder.toUser(wxMessage.getFromUserName()).fromUser(wxMessage.getToUserName()).build();
	}

	/**
	 * 根据分数创建星星
	 * 
	 * @param score
	 * @return
	 */
	private String createStarsByScore(int score) {
		String stars = "";
		int solidStarsNum = Math.floorDiv(score + 10, 20);
		for (int i = 0; i < solidStarsNum; i++) {
			stars += "★";
		}
		int hollowStarsNum = 5 - solidStarsNum;
		for (int i = 0; i < hollowStarsNum; i++) {
			stars += "☆";
		}
		return stars;
	}

}
