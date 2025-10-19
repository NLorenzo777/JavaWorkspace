package com.acn.SimpleRestApi.exceptions;

public class NoSuchCustomerExistsException extends RuntimeException {

  private String message;

  public NoSuchCustomerExistsException(String message) {
    super(message);
    this.message = message;
  }
}
