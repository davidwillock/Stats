package com.charlie1.simulator.client.domain;

/**
 * Status of a submitted order.
 */
public enum OrderStatus {
  NEW,
  PARTIALLY_FILLED,
  FILLED,
  CANCELED,
  PENDING_CANCEL,
  REJECTED,
  EXPIRED
}

