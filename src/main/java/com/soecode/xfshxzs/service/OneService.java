package com.soecode.xfshxzs.service;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.soecode.xfshxzs.po.one.Article;
import com.soecode.xfshxzs.po.one.Music;
import com.soecode.xfshxzs.po.one.One;
import com.soecode.xfshxzs.po.one.Picture;
import com.soecode.xfshxzs.po.one.Question;
import com.soecode.xfshxzs.util.HttpUitl;

/**
 * ONE业务（图片、阅读、问答、音乐）
 * 
 * {@link http://m.wufazhuce.com}
 */
public class OneService {

	// ONE首页URL（图片、阅读、问答）
	private static final String ONE_URL = "http://m.wufazhuce.com";

	// 音乐列表URL
	private static final String MUSIC_LIST_URL = "http://v3.wufazhuce.com:8000/api/music/idlist/0";

	// 音乐详细URL
	private static final String MUSIC_DETAIL_URL = "http://v3.wufazhuce.com:8000/api/music/detail/ID";

	public One getOne() {
		One one = new One();
		try {
			String html = HttpUitl.doGet(ONE_URL);
			Document document = Jsoup.parse(html);

			// ONE
			String vol = document.select(".month").text().split("\\|")[0].trim();
			String date = document.select(".day").text() + document.select(".month").text().split("\\|")[1];
			one.setVol(vol);
			one.setDate(date);

			// 图片
			Picture picture = new Picture();
			String picture_imageUrl = document.select(".home-img").attr("style").split("\\(")[1].replace(")", "");
			String picture_content = document.select("#quote").text();
			String pucture_webUrl = document.select(".sentence .div-link").attr("href");
			String picture_id = pucture_webUrl.split("/")[pucture_webUrl.split("/").length - 1];
			picture.setId(picture_id);
			picture.setContent(picture_content);
			picture.setImage_url(picture_imageUrl);
			picture.setWeb_url(pucture_webUrl);
			one.setPicture(picture);

			// 阅读
			Article article = new Article();
			String article_title = document.select(".article .text-title").text();
			String article_author = document.select(".article .text-author").text().split("／")[1];
			String article_webUlr = document.select(".article .div-link").attr("href");
			String article_id = article_webUlr.split("/")[article_webUlr.split("/").length - 1];
			article.setId(article_id);
			article.setTitle(article_title);
			article.setAuthor(article_author);
			article.setWeb_url(article_webUlr);
			one.setArticle(article);

			// 问答
			Question question = new Question();
			String question_title = document.select(".question .text-title").text();
			String question_webUrl = document.select(".question .div-link").attr("href");
			String question_id = question_webUrl.split("/")[question_webUrl.split("/").length - 1];
			question.setId(question_id);
			question.setTitle(question_title);
			question.setWeb_url(question_webUrl);
			one.setQuestion(question);

			// 音乐
			Music music = new Music();
			String json1 = HttpUitl.doGet(MUSIC_LIST_URL);// 加载音乐ID列表
			ObjectMapper mapper = new ObjectMapper();
			JsonNode root1 = mapper.readTree(json1);
			String music_id = root1.path("data").get(0).asText();// 获取第一个音乐ID
			String json2 = HttpUitl.doGet(MUSIC_DETAIL_URL.replace("ID", music_id));// 加载音乐详细
			JsonNode root2 = mapper.readTree(json2);
			JsonNode data = root2.path("data");
			music.setId(music_id);
			music.setTitle(data.path("title").asText());
			music.setAuthor(data.path("author").path("user_name").asText());
			music.setCover(data.path("cover").asText());
			music.setWeb_url(data.path("web_url").asText());
			one.setMusic(music);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return one;
	}

}
