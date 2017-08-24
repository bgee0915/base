package com.bgee.base.httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * 简单的 httpclient 模拟 get 请求
 * @author bgee
 *
 */
public class HttpClientGet {
	public static void main(String[] args) {
		
		try {
			CloseableHttpClient httpClient = HttpClients.createDefault();
			HttpGet httpGet = new HttpGet("http://www.tuicool.com");
			CloseableHttpResponse response = null;
			response = httpClient.execute(httpGet);
			HttpEntity entity = response.getEntity();
			String result = EntityUtils.toString(entity,"utf-8");
			System.out.println(result);
			
			response.close();
			httpClient.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
