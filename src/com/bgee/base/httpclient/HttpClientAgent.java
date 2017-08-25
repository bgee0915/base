package com.bgee.base.httpclient;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.bgee.base.util.FunUtil;

public class HttpClientAgent {
	public static void main(String[] args) {
		try {
			CloseableHttpClient httpClient = HttpClients.createDefault();
			HttpGet httpGet = new HttpGet("http://www.tuicool.com");
			
//			设置请求头 模拟浏览器，防止被屏蔽
			httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36");
			HttpResponse response = httpClient.execute(httpGet);
			
//			获取状态信息 状态码
			
			StatusLine status = response.getStatusLine();
			int code = status.getStatusCode();
			FunUtil.println("\n\n","status=",status,"code=",code);
			
			
			HttpEntity entity = response.getEntity();
			String result = EntityUtils.toString(entity);
			FunUtil.print(result, "\n\n----------------------\n\n");
			
//			特征识别
//			响应信息
			Header header = entity.getContentType();
			String key = header.getName();
			String value = header.getValue();
			FunUtil.println("key=",key,"\n","value=",value);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
//______________ 
//< WWW.ABC.COM >
//-------------- 
//\   ^__^
// \  (**)\__$__$__
//    (__)\       )\/\
//     U  ||------|
//        ||     ||
