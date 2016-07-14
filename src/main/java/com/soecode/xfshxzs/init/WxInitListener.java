package com.soecode.xfshxzs.init;

import java.io.File;

import javax.servlet.ServletContextEvent;

import org.apache.commons.logging.impl.ServletContextCleaner;

import com.soecode.wxtools.api.WxConfigStorage;
import com.soecode.wxtools.api.WxInMemoryConfigStorage;
import com.soecode.wxtools.api.WxService;
import com.soecode.wxtools.api.WxServiceImpl;

/**
 * 初始化配置库和微信API服务
 */
public class WxInitListener extends ServletContextCleaner {

	// 配置库
	private WxConfigStorage config = null;
	// API Service
	private WxService wxService = null;

	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("------实例化config和service----------");
		// 调用默认基于内存的配置库WxInMemoryConfigStorage的getInstance获得实例。注意这里是单例模式
		config = WxInMemoryConfigStorage.getInstance();
		// 设置AppId
		config.setAppId("***");
		// 设置AppSecret
		config.setAppSecret("***");
		// 设置token
		config.setToken("***");
		// 设置临时资源文件存放路径
		config.setTmpDirFile(new File("C://test"));
		// 设置永久资源文件存放路径
		config.setMaterialDirFile(new File("C://test"));
		// 获得WxService实例，注意这里也是调用getInstance()方法获取唯一的业务对象
		wxService = WxServiceImpl.getInstance();
		// 注入配置库
		wxService.setWxConfigStorage(config);
	}

	public void contextDestroyed(ServletContextEvent arg0) {
        // ...
    }
}
