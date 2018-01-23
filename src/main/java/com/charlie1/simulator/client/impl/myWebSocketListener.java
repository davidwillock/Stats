package com.charlie1.simulator.client.impl;

import com.charlie1.simulator.client.constant.BinanceApiConstants;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.WebSocketListener;


import com.charlie1.simulator.client.BinanceApiCallback;
import com.charlie1.simulator.client.exception.BinanceApiException;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.Response;
import okhttp3.WebSocket;





public class myWebSocketListener extends WebSocketListener {
	

	private OkHttpClient client;

	  public myWebSocketListener() {
	    this.client = new OkHttpClient();
	  }

	
	
	void createNewWebSocket(String channel, myWebSocketListener listener) {
		  
		 String url= "charlie.com";
		 WebSocketListener tt;
		
		 myWebSocketListener myWeb = new myWebSocketListener();
		 
	    String streamingUrl = String.format("%s/%s", BinanceApiConstants.WS_API_BASE_URL, channel);
	   Request request = new Request.Builder().url(streamingUrl).build();
	  /// Request request = new Request.Builder().url(url).build();
	  //WebSocket ws =   client.newWebSocket(request, myWeb);
	     
	     
	    
	    
	
	
	
	}
}
