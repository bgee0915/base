package com.bgee.base.httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpClientProxy {
	public static void main(String[] args) {
		try {
			CloseableHttpClient httpClient = HttpClients.createDefault();
			HttpGet httpGet = new HttpGet("http://www.tuicool.com");
			HttpHost host = new HttpHost("114.95.184.160",63909);
			RequestConfig config = RequestConfig.custom().setProxy(host).build();
			httpGet.setConfig(config);
//			httpGet.setHeader("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36");
			HttpResponse response = httpClient.execute(httpGet);
			HttpEntity entity = response.getEntity();
			System.out.println(EntityUtils.toString(entity));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
