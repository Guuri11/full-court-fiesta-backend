package com.fullcourtfiesta.courtservice.application.exception;

public class NotFoundException extends RuntimeException {

  public NotFoundException() {

    super("Could not find item");
  }

  public NotFoundException(final Long id) {

    super("Could not find item with ID " + id);
  }
}
