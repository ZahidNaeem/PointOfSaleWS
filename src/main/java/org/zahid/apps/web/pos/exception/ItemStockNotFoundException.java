package org.zahid.apps.web.pos.exception;

public class ItemStockNotFoundException extends RuntimeException {

  public ItemStockNotFoundException(String message) {
    super(message);
  }
}
