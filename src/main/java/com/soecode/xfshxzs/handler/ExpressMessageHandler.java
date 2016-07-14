package com.soecode.xfshxzs.handler;

import java.util.Map;

import com.soecode.wxtools.api.WxMessageHandler;
import com.soecode.wxtools.api.WxService;
import com.soecode.wxtools.bean.WxXmlMessage;
import com.soecode.wxtools.bean.WxXmlOutMessage;
import com.soecode.wxtools.exception.WxErrorException;
import com.soecode.xfshxzs.enums.ExpressStateEnum;
import com.soecode.xfshxzs.po.express.Express;
import com.soecode.xfshxzs.service.ExpressService;
import com.soecode.xfshxzs.util.EmojiUtil;

/**
 * 快递消息处理器
 */
public class ExpressMessageHandler implements WxMessageHandler {

    ExpressService expressService = new ExpressService();

    public WxXmlOutMessage handle(WxXmlMessage wxMessage, Map<String, Object> context, WxService wxService)
            throws WxErrorException {
        String postId = wxMessage.getContent().trim();
        try {
            Express express = expressService.getExpressByPostId(postId);
            StringBuffer sb = new StringBuffer();
            sb.append("【物流公司】" + express.getCom() + "\n");
            sb.append("【快递单号】" + express.getNu() + "\n");
            sb.append("【状态】" + ExpressStateEnum.stateOf(express.getState()).getStateInfo() + "\n");
            sb.append("【最新物流】" + express.getData().get(0).getContext() + "\n");
            sb.append("【更新时间】" + express.getData().get(0).getTime() + "\n");
            sb.append(EmojiUtil.emoji(EmojiUtil.RIGHT_HAND) + "<a href=\"" + express.getUrl() + "\">点击这里查看详细物流信息</a>");
            String message = sb.toString();
            return WxXmlOutMessage.TEXT().content(message).toUser(wxMessage.getFromUserName())
                    .fromUser(wxMessage.getToUserName()).build();
        } catch (Exception e) {
            e.printStackTrace();
            String message = EmojiUtil.emoji(EmojiUtil.CROSS) + "查询不到订单号为\"" + postId + "\"的物流信息！";
            return WxXmlOutMessage.TEXT().content(message).toUser(wxMessage.getFromUserName())
                    .fromUser(wxMessage.getToUserName()).build();
        }
    }

}
