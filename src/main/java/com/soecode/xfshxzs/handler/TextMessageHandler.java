package com.soecode.xfshxzs.handler;

import java.util.Map;

import com.soecode.wxtools.api.WxMessageHandler;
import com.soecode.wxtools.api.WxService;
import com.soecode.wxtools.bean.WxXmlMessage;
import com.soecode.wxtools.bean.WxXmlOutMessage;
import com.soecode.wxtools.bean.WxXmlOutNewsMessage.Item;
import com.soecode.wxtools.bean.outxmlbuilder.NewsBuilder;
import com.soecode.wxtools.exception.WxErrorException;
import com.soecode.xfshxzs.util.EmojiUtil;

/**
 * 文本消息处理器
 */
public class TextMessageHandler implements WxMessageHandler {

	public WxXmlOutMessage handle(WxXmlMessage wxMessage, Map<String, Object> context, WxService wxService)
			throws WxErrorException {
		String message = null;
		String content = wxMessage.getContent();
		WxXmlOutMessage xmlOutMsg = null;
		if ("?".equals(content) || "？".equals(content) || "帮助".equals(content) || "菜单".equals(content)) {
			StringBuffer sb = new StringBuffer();
			sb.append("感谢您使用，回复关键字：\n\n");
			sb.append(EmojiUtil.emoji(EmojiUtil.MOVIE) + "【电影】查看近期电影评分\n");
			sb.append(EmojiUtil.emoji(EmojiUtil.MONKEY) + "【来一发】每天都有福利\n");
			sb.append(EmojiUtil.emoji(EmojiUtil.PENCEIL) + "【测试】查看所有测试\n");
			sb.append(EmojiUtil.emoji(EmojiUtil.GAME) + "【游戏】查看所有游戏\n");
			sb.append(EmojiUtil.emoji(EmojiUtil.BUS) + "【公交】查实时公交地铁图\n");
			sb.append(EmojiUtil.emoji(EmojiUtil.WEATHER) + "【XX天气】查询天气预报\n");
			sb.append(EmojiUtil.emoji(EmojiUtil.TRUCK) + "【快递单号】查询快递信息\n\n");
			sb.append("回复【?】查看主菜单");
			message = sb.toString();
			xmlOutMsg = WxXmlOutMessage.TEXT().content(message).toUser(wxMessage.getFromUserName())
					.fromUser(wxMessage.getToUserName()).build();
		} else if ("天气".equals(content)) {
			message = "请直接回复【XX天气】，例如：查询珠海天气回复\"珠海天气\"";
			xmlOutMsg = WxXmlOutMessage.TEXT().content(message).toUser(wxMessage.getFromUserName())
					.fromUser(wxMessage.getToUserName()).build();
		} else if ("快递".equals(content)) {
			message = "请直接回复【快递单号】，例如：查询京东快递回复订单号\"20146073240\"，无需输入物流公司";
			xmlOutMsg = WxXmlOutMessage.TEXT().content(message).toUser(wxMessage.getFromUserName())
					.fromUser(wxMessage.getToUserName()).build();
		}

		else if ("测试".equals(content)) {
			Item item = new Item();
			item.setTitle("点击进入查看所有测试");
			item.setDescription("来源：小数据");
			item.setPicUrl("http://www.arealme.com/newimg/tn_@2x_health.png");
			item.setUrl("http://cn.arealme.com/?lang=cn");
			xmlOutMsg = WxXmlOutMessage.NEWS().addArticle(item).toUser(wxMessage.getFromUserName())
					.fromUser(wxMessage.getToUserName()).build();
		} else if ("游戏".equals(content)) {
			Item item = new Item();
			item.setTitle("点击进入查看所有游戏");
			item.setDescription("来源：二店长的小游戏");
			item.setPicUrl("http://img2.imgtn.bdimg.com/it/u=4036230424,3195861116&fm=21&gp=0.jpg");
			item.setUrl("http://s2.erdianzhang.com/gameList");
			xmlOutMsg = WxXmlOutMessage.NEWS().addArticle(item).toUser(wxMessage.getFromUserName())
					.fromUser(wxMessage.getToUserName()).build();
		} else if ("公交".equals(content)) {
			NewsBuilder builder = WxXmlOutMessage.NEWS();
			// 1.珠海公交
			Item item1 = new Item();
			item1.setTitle("珠海实时公交查询");
			item1.setPicUrl(
					"https://ss1.baidu.com/70cFfyinKgQFm2e88IuM_a/forum/pic/item/4b90f603738da977250355a4b551f8198618e315.jpg");
			item1.setUrl("http://www.zhbuswx.com/busline/BusQuery.html");
			builder.addArticle(item1);
			// 2.全国公交
			Item item2 = new Item();
			item2.setTitle("全国城市实时公交查询");
			item2.setPicUrl("http://img5.imgtn.bdimg.com/it/u=2035560368,2960572219&fm=21&gp=0.jpg");
			item2.setUrl("http://www.chedaona.cn/route/wap/index");
			builder.addArticle(item2);
			// 3.附近公交站点
			Item item3 = new Item();
			item3.setTitle("附近公交站查询");
			item3.setPicUrl("http://img5.imgtn.bdimg.com/it/u=2035560368,2960572219&fm=21&gp=0.jpg");
			item3.setUrl("http://www.nwei.com.cn/near.htm");
			builder.addArticle(item3);
			// 4.地铁图
			Item item4 = new Item();
			item4.setTitle("全国城市地铁图");
			item4.setPicUrl("http://img4.imgtn.bdimg.com/it/u=555051301,1466834025&fm=21&gp=0.jpg");
			item4.setUrl("http://map.baidu.com/mobile/webapp/index/setsubwaycity/force=simple");
			builder.addArticle(item4);
			// 5.广州地铁
			Item item5 = new Item();
			item5.setTitle("回复【广州地铁】可查看线网图、客流实况、在线购买单程票");
			item5.setPicUrl("https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=2214113435,2045471970&fm=58");
			item5.setUrl("http://map.baidu.com/mobile/webapp/subway/show/foo=bar&city=guangzhou/");
			builder.addArticle(item5);
			xmlOutMsg = builder.toUser(wxMessage.getFromUserName()).fromUser(wxMessage.getToUserName()).build();
		} else if ("广州地铁".equals(content)) {
			NewsBuilder builder = WxXmlOutMessage.NEWS();
			// 1.线网图
			Item item2 = new Item();
			item2.setTitle("查询广州地铁线网图");
			item2.setPicUrl("http://58.63.71.40/gzmetroWeifuwu/images/newmap.jpg");
			item2.setUrl("http://58.63.71.40/gzmetroWeifuwu/images/newmap.jpg");
			builder.addArticle(item2);
			// 2.客流实况
			Item item1 = new Item();
			item1.setTitle("查询地铁客流实况");
			item1.setUrl("http://ydyc.gzmtr.cn:13050/?s=wechat");
			builder.addArticle(item1);
			// 3.普通单程票
			Item item3 = new Item();
			item3.setTitle("购买普通单程票");
			item3.setUrl("http://dzs.gzmtr.cn/wxpay/modules/index.php");
			builder.addArticle(item3);
			// 4.APM单程票
			Item item4 = new Item();
			item4.setTitle("购买APM单程票");
			item4.setUrl("http://dzs.gzmtr.cn/wxpay/modules/indexapm.php");
			builder.addArticle(item4);
			xmlOutMsg = builder.toUser(wxMessage.getFromUserName()).fromUser(wxMessage.getToUserName()).build();
		} else {
			message = "\"" + content + "\"是什么鬼，我不懂！\n回复【?】查看帮助菜单";
			xmlOutMsg = WxXmlOutMessage.TEXT().content(message).toUser(wxMessage.getFromUserName())
					.fromUser(wxMessage.getToUserName()).build();
		}
		return xmlOutMsg;
	}

}
