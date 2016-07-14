package com.soecode.xfshxzs.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.soecode.wxtools.exception.WxErrorException;
import com.soecode.wxtools.util.http.SimpleGetRequestExecutor;
import com.soecode.wxtools.util.http.SimplePostRequestExecutor;

/**
 * HTTP工具类
 */
public class HttpUitl {

	/**
	 * 普通GET请求
	 * 
	 * @param uri
	 * @return
	 * @throws IOException
	 * @throws ClientProtocolException
	 */
	public static String doGet(String uri) throws ClientProtocolException, IOException {
		String html = null;
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(uri);
		CloseableHttpResponse response = httpClient.execute(httpGet);
		HttpEntity entity = response.getEntity();
		if (entity != null) {
			html = EntityUtils.toString(entity);
			EntityUtils.consume(entity);
		}
		httpGet.releaseConnection();
		response.close();
		return html;
	}

	/**
	 * 带参数的GET请求
	 * 
	 * @param uri
	 * @param params
	 * @return
	 * @throws IOException
	 * @throws ClientProtocolException
	 */
	public static String doGet(String uri, Map<String, String> params) throws ClientProtocolException, IOException {
		if (params != null) {
			uri += '?';
			for (String key : params.keySet()) {
				uri += key + "=" + params.get(key) + "&";
			}
			uri = uri.substring(0, uri.length() - 1);
		}
		String html = null;
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(uri);
		CloseableHttpResponse response = httpClient.execute(httpGet);
		HttpEntity entity = response.getEntity();
		if (entity != null) {
			html = EntityUtils.toString(entity);
			EntityUtils.consume(entity);
		}
		httpGet.releaseConnection();
		response.close();
		return html;
	}

	/**
	 * 带请求头和参数的GET请求
	 * 
	 * @param uri
	 * @param headers
	 * @param params
	 * @return
	 * @throws IOException
	 * @throws ClientProtocolException
	 */
	public static String doGet(String uri, Map<String, String> headers, Map<String, String> params)
			throws ClientProtocolException, IOException {
		if (params != null) {
			uri += '?';
			for (String key : params.keySet()) {
				uri += key + "=" + params.get(key) + "&";
			}
			uri = uri.substring(0, uri.length() - 1);
		}
		String html = null;
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(uri);
		if (headers != null) {
			for (String key : headers.keySet()) {
				httpGet.setHeader(key, headers.get(key));
			}
		}
		CloseableHttpResponse response = httpClient.execute(httpGet);
		HttpEntity entity = response.getEntity();
		if (entity != null) {
			html = EntityUtils.toString(entity);
			EntityUtils.consume(entity);
		}
		httpGet.releaseConnection();
		response.close();
		return html;
	}

	/**
	 * 普通POST请求
	 * 
	 * @param uri
	 * @param params
	 * @return
	 * @throws IOException
	 * @throws ClientProtocolException
	 */
	public static String doPost(String uri, Map<String, String> params) throws ClientProtocolException, IOException {
		String html = null;
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(uri);
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		for (Map.Entry<String, String> entry : params.entrySet()) {
			nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
		}
		httpPost.setEntity(new UrlEncodedFormEntity(nvps));
		CloseableHttpResponse response = httpClient.execute(httpPost);
		HttpEntity entity = response.getEntity();
		if (entity != null) {
			html = EntityUtils.toString(entity);
			EntityUtils.consume(entity);
		}
		httpPost.releaseConnection();
		response.close();
		return html;
	}

}
