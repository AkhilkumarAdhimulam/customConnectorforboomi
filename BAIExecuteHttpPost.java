package com.eaiesb.boomi.operation;

import java.util.List;


import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class BAIExecuteHttpPost {
	
	protected static String httpPost(String BaiURL, List<Object> payload) {
		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(BaiURL);
		try {
			StringEntity entity = new StringEntity(payload.toString());
			httpPost.setEntity(entity);
			httpPost.setHeader("Accept","application/json");
			httpPost.setHeader("Content-Type","application/json");
			client.execute((HttpUriRequest)httpPost);
			client.close();
			
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		return "HTTP POST Success";
		
	}
}
