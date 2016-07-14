package com.soecode.xfshxzs.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soecode.wxtools.api.WxConfigStorage;
import com.soecode.wxtools.api.WxConsts;
import com.soecode.wxtools.api.WxInMemoryConfigStorage;
import com.soecode.wxtools.api.WxMessageRouter;
import com.soecode.wxtools.api.WxService;
import com.soecode.wxtools.api.WxServiceImpl;
import com.soecode.wxtools.bean.WxXmlMessage;
import com.soecode.wxtools.bean.WxXmlOutMessage;
import com.soecode.wxtools.util.xml.XStreamTransformer;
import com.soecode.xfshxzs.handler.ExpressMessageHandler;
import com.soecode.xfshxzs.handler.MovieMessageHandler;
import com.soecode.xfshxzs.handler.OneMessageHandler;
import com.soecode.xfshxzs.handler.SubscribeEventHandler;
import com.soecode.xfshxzs.handler.TextMessageHandler;
import com.soecode.xfshxzs.handler.WeatherMessageHandler;
import com.soecode.xfshxzs.matcher.ExpressMatcher;

/**
 * 接收微信服务器请求
 */
@WebServlet("/wx")
public class WxServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private WxConfigStorage config;
    private WxService service;
    private WxMessageRouter router;

    public WxServlet() {
        config = WxInMemoryConfigStorage.getInstance();
        service = WxServiceImpl.getInstance();
        service.setWxConfigStorage(config);
        router = new WxMessageRouter(WxServiceImpl.getInstance());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 验证服务器的有效性
        PrintWriter out = response.getWriter();
        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");
        if (WxServiceImpl.getInstance().checkSignature(signature, timestamp, nonce, echostr)) {
            out.print(echostr);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 设置编码格式为utf-8，防止中文乱码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = null;
        try {
            out = response.getWriter();
            WxXmlMessage wx = XStreamTransformer.fromXml(WxXmlMessage.class, request.getInputStream());
            wx.setContent(wx.getContent().trim());// 过滤两边空格
            System.out.println("消息：\n " + wx.toString());
            // 订阅事件
            router.rule().async(false).msgType(WxConsts.XML_MSG_EVENT).event(WxConsts.EVT_SUBSCRIBE)
                    .handler(new SubscribeEventHandler()).end();
            // 文本消息
            router.rule().async(false).msgType(WxConsts.XML_MSG_TEXT).handler(new TextMessageHandler()).next();
            // 电影消息
            router.rule().async(false).msgType(WxConsts.XML_MSG_TEXT).rContent("电影|更多")
                    .handler(new MovieMessageHandler()).end();
            // ONE消息
            router.rule().async(false).msgType(WxConsts.XML_MSG_TEXT).rContent("来一发").handler(new OneMessageHandler())
                    .end();
            // 天气消息
            router.rule().async(false).msgType(WxConsts.XML_MSG_TEXT).rContent("(.+?天气)")
                    .handler(new WeatherMessageHandler()).end();
            // 快递消息
            router.rule().async(false).msgType(WxConsts.XML_MSG_TEXT).matcher(new ExpressMatcher())
                    .handler(new ExpressMessageHandler()).end();
            WxXmlOutMessage xmlOutMsg = router.route(wx);
            if (xmlOutMsg != null)
                out.print(xmlOutMsg.toXml());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            out.close();
        }
    }

}