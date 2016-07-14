package com.soecode.xfshxzs.service;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

import com.soecode.xfshxzs.po.express.Express;
import com.soecode.xfshxzs.util.HttpUitl;

/**
 * 快递业务
 * 
 * {@link https://www.kuaidi100.com/openapi/api_post.shtml}
 */
public class ExpressService {

	// 判断快递公司
	private static final String EXPRESS_AUTOCOMNUM_URL = "http://www.kuaidi100.com/autonumber/autoComNum?text=POSTID";

	// 查询物流信息
	private static final String EXPRESS_QUERY_URL = "http://www.kuaidi100.com/query?type=TYPE&postid=POSTID";

	// 手机版
	private static final String EXPRESS_MOBILE_URL = "http://m.kuaidi100.com/index_all.html?type=TYPE&postid=POSTID";

	/**
	 * 根据快递单号查询物流信息
	 * 
	 * @param postId
	 * @return
	 */
	public Express getExpressByPostId(String postId) {
		Express express = new Express();
		try {
			String json = HttpUitl.doGet(EXPRESS_AUTOCOMNUM_URL.replace("POSTID", postId));
			ObjectMapper mapper = new ObjectMapper();
			JsonNode root = mapper.readTree(json);
			JsonNode auto = root.path("auto");
			if (!auto.isNull()) {
				String comCode = auto.get(0).path("comCode").asText();
				json = HttpUitl.doGet(EXPRESS_QUERY_URL.replace("TYPE", comCode).replace("POSTID", postId));
				mapper = new ObjectMapper();
				express = mapper.readValue(json, Express.class);
				express.setUrl(EXPRESS_MOBILE_URL.replace("POSTID", postId));
			} else {
				return null;
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return express;
	}

}
