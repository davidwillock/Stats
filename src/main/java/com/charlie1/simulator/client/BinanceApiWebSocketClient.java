package com.charlie1.simulator.client;


import com.charlie1.simulator.client.domain.event.AggTradeEvent;
import com.charlie1.simulator.client.domain.event.CandlestickEvent;
import com.charlie1.simulator.client.domain.event.DepthEvent;
import com.charlie1.simulator.client.domain.event.UserDataUpdateEvent;
import com.charlie1.simulator.client.domain.market.CandlestickInterval;

/**
 * Binance API data streaming façade, supporting streaming of events through web sockets.
 */
public interface BinanceApiWebSocketClient {

  void onDepthEvent(String symbol, BinanceApiCallback<DepthEvent> callback);

  void onCandlestickEvent(String symbol, CandlestickInterval interval, BinanceApiCallback<CandlestickEvent> callback);

  void onAggTradeEvent(String symbol, BinanceApiCallback<AggTradeEvent> callback);

  void onUserDataUpdateEvent(String listenKey, BinanceApiCallback<UserDataUpdateEvent> callback);
}


