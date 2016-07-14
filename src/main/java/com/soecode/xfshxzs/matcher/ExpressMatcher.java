package com.soecode.xfshxzs.matcher;

import com.soecode.wxtools.api.WxMessageMatcher;
import com.soecode.wxtools.bean.WxXmlMessage;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * 快递单号匹配器
 */
public class ExpressMatcher implements WxMessageMatcher {

    public boolean match(WxXmlMessage message) {
        String content = message.getContent();
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher matcher = pattern.matcher(content);
        // 如果是数字且长度不小于10位则匹配
        if (matcher.matches() && content.length() >= 10) {
            return true;
        }
        return false;
    }
}