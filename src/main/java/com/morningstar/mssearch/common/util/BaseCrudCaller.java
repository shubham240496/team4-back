package com.morningstar.mssearch.common.util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;



import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

@Component
public class BaseCrudCaller {

	public String getMstarData(Map<String, String> header, String url) throws IOException
	{
		try {
			HttpGet httpGet = new HttpGet(url);
			//httpGet.addHeader("Accept", "application/json");
			for (Map.Entry<String, String> entry : header.entrySet())
				httpGet.addHeader(entry.getKey(), entry.getValue());



			HttpClient client = HttpClients.createDefault();
			HttpResponse response = client.execute(httpGet);

			response = client.execute(httpGet);

			String result = null;

			if (response != null){
				HttpEntity responseEntity = response.getEntity() ;
				if (responseEntity != null){
					InputStream responseStream = responseEntity.getContent() ;
					result = org.apache.commons.io.IOUtils.toString(responseStream, "utf-8");
					System.out.println(result);
					return result;
				}
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}

		return null;
	}
}




