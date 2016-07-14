package com.soecode.xfshxzs.handler;

import java.util.Map;

import com.soecode.wxtools.api.WxMessageHandler;
import com.soecode.wxtools.api.WxService;
import com.soecode.wxtools.bean.WxXmlMessage;
import com.soecode.wxtools.bean.WxXmlOutMessage;
import com.soecode.wxtools.bean.WxXmlOutNewsMessage.Item;
import com.soecode.wxtools.bean.outxmlbuilder.NewsBuilder;
import com.soecode.wxtools.exception.WxErrorException;
import com.soecode.xfshxzs.po.one.Article;
import com.soecode.xfshxzs.po.one.Music;
import com.soecode.xfshxzs.po.one.One;
import com.soecode.xfshxzs.po.one.Picture;
import com.soecode.xfshxzs.po.one.Question;
import com.soecode.xfshxzs.service.OneService;

/**
 * ONE消息处理器
 */
public class OneMessageHandler implements WxMessageHandler {

	private OneService oneService = new OneService();

	public WxXmlOutMessage handle(WxXmlMessage wxMessage, Map<String, Object> context, WxService wxService)
			throws WxErrorException {
		NewsBuilder builder = WxXmlOutMessage.NEWS();
		One one = oneService.getOne();
		// 1.图片
		Picture picture = one.getPicture();
		Item item1 = new Item();
		item1.setTitle(one.getVol() + " | " + picture.getContent());
		item1.setPicUrl(picture.getImage_url());
		item1.setUrl(picture.getWeb_url());
		builder.addArticle(item1);
		// 2.阅读
		Article article = one.getArticle();
		Item item2 = new Item();
		item2.setTitle("阅读 | " + article.getTitle() + " | 作者/" + article.getAuthor());
		item2.setPicUrl("http://www.easyicon.net/api/resizeApi.php?id=1199738&size=72");
		item2.setUrl(article.getWeb_url());
		builder.addArticle(item2);
		// 3.问答
		Question question = one.getQuestion();
		Item item3 = new Item();
		item3.setTitle("问答 | " + question.getTitle());
		item3.setPicUrl("http://www.easyicon.net/api/resizeApi.php?id=1197806&size=64");
		item3.setUrl(question.getWeb_url());
		builder.addArticle(item3);
		// 4.音乐
		Music music = one.getMusic();
		Item item4 = new Item();
		item4.setTitle("音乐 | " + music.getTitle() + " | 作者/" + music.getAuthor());
		item4.setPicUrl(music.getCover());
		item4.setUrl(music.getWeb_url());
		builder.addArticle(item4);
		// 5.往期
		Item item5 = new Item();
		item5.setTitle("更多 | 查看往期内容");
		item5.setPicUrl("http://www.easyicon.net/api/resizeApi.php?id=1137914&size=64");
		item5.setUrl("http://m.wufazhuce.com/index");
		builder.addArticle(item5);
		// 6.电影
		Item item6 = new Item();
		item6.setTitle("回复【电影】查看近期电影评分");
		item6.setPicUrl("http://www.easyicon.net/api/resizeApi.php?id=1194530&size=72");
		builder.addArticle(item6);
		return builder.toUser(wxMessage.getFromUserName()).fromUser(wxMessage.getToUserName()).build();
	}

}
