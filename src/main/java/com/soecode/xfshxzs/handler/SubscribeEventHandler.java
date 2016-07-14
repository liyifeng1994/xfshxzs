package com.soecode.xfshxzs.handler;

import java.util.Map;

import com.soecode.wxtools.api.WxMessageHandler;
import com.soecode.wxtools.api.WxService;
import com.soecode.wxtools.bean.WxXmlMessage;
import com.soecode.wxtools.bean.WxXmlOutMessage;
import com.soecode.wxtools.exception.WxErrorException;
import com.soecode.xfshxzs.util.EmojiUtil;

/**
 * 文本消息处理器
 */
public class SubscribeEventHandler implements WxMessageHandler {

	public WxXmlOutMessage handle(WxXmlMessage wxMessage, Map<String, Object> context, WxService wxService)
			throws WxErrorException {
		StringBuffer sb = new StringBuffer();
		sb.append("欢迎关注小锋生活小助手！\n");
		sb.append("请根据提示回复关键字：\n\n");
		sb.append(EmojiUtil.emoji(EmojiUtil.MOVIE) + "【电影】查看近期电影评分\n");
		sb.append(EmojiUtil.emoji(EmojiUtil.MONKEY) + "【来一发】每天都有福利\n");
		sb.append(EmojiUtil.emoji(EmojiUtil.PENCEIL) + "【测试】查看所有测试\n");
		sb.append(EmojiUtil.emoji(EmojiUtil.GAME) + "【游戏】查看所有游戏\n");
		sb.append(EmojiUtil.emoji(EmojiUtil.BUS) + "【公交】查实时公交地铁图\n");
		sb.append(EmojiUtil.emoji(EmojiUtil.WEATHER) + "【XX天气】查询天气预报\n");
		sb.append(EmojiUtil.emoji(EmojiUtil.TRUCK) + "【快递单号】查询快递信息\n\n");
		sb.append("回复【?】查看主菜单");
		String message = sb.toString();
		return WxXmlOutMessage.TEXT().content(message).toUser(wxMessage.getFromUserName())
				.fromUser(wxMessage.getToUserName()).build();
	}

}
