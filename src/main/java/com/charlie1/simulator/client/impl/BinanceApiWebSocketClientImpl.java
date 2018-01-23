package com.charlie1.simulator.client.impl;

import com.charlie1.simulator.client.BinanceApiCallback;
import com.charlie1.simulator.client.BinanceApiWebSocketClient;
import com.charlie1.simulator.client.constant.BinanceApiConstants;
import com.charlie1.simulator.client.domain.event.AggTradeEvent;
import com.charlie1.simulator.client.domain.event.CandlestickEvent;
import com.charlie1.simulator.client.domain.event.DepthEvent;
import com.charlie1.simulator.client.domain.event.UserDataUpdateEvent;
import com.charlie1.simulator.client.domain.market.CandlestickInterval;

import com.charlie1.simulator.client.impl.BinanceApiWebSocketListener;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.WebSocketListener;

import java.io.Closeable;
import java.io.IOException;


/**
 * Binance API WebSocket client implementation using OkHttp.
 */
public class BinanceApiWebSocketClientImpl  implements BinanceApiWebSocketClient, Closeable {

  private OkHttpClient client;

  public BinanceApiWebSocketClientImpl() {
    this.client = new OkHttpClient();
  }

  public void onDepthEvent(String symbol, BinanceApiCallback<DepthEvent> callback) {
    final String channel = String.format("%s@depth", symbol);
    createNewWebSocket(channel, new BinanceApiWebSocketListener<>(callback, DepthEvent.class));
  }

  @Override
  public void onCandlestickEvent(String symbol, CandlestickInterval interval, BinanceApiCallback<CandlestickEvent> callback) {
    final String channel = String.format("%s@kline_%s", symbol, interval.getIntervalId());
    createNewWebSocket(channel, new BinanceApiWebSocketListener<>(callback, CandlestickEvent.class));
  }

  public void onAggTradeEvent(String symbol, BinanceApiCallback<AggTradeEvent> callback) {
    final String channel = String.format("%s@aggTrade", symbol);
    createNewWebSocket(channel, new BinanceApiWebSocketListener<>(callback, AggTradeEvent.class));
  }

  public void onUserDataUpdateEvent(String listenKey, BinanceApiCallback<UserDataUpdateEvent> callback) {
    createNewWebSocket(listenKey, new BinanceApiWebSocketListener<>(callback, UserDataUpdateEvent.class));
  }

//  private void createNewWebSocket(String channel, BinanceApiWebSocketListener<?> listener) {
  
  private void createNewWebSocket(String channel, BinanceApiWebSocketListener<?> listener) {
  
	  myWebSocketListener list = new myWebSocketListener();
	  BinanceApiWebSocketClientImpl imp = new BinanceApiWebSocketClientImpl();
	 
    String streamingUrl = String.format("%s/%s", BinanceApiConstants.WS_API_BASE_URL, channel);
    Request request = new Request.Builder().url(streamingUrl).build();
  //  client.newWebSocket(request, list);
    
    
  
 
  }

  @Override
  public void close() throws IOException {
    client.dispatcher().executorService().shutdown();
}
  
}



