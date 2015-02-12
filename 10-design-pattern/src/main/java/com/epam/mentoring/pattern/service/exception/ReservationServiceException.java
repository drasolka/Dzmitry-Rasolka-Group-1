package com.epam.mentoring.pattern.service.exception;

public class ReservationServiceException extends Exception {

    public ReservationServiceException() {
        super();
    }

    public ReservationServiceException(Exception ex) {
        super(ex);
    }

    public ReservationServiceException(String errorMessage) {
        super(errorMessage);
    }

    public ReservationServiceException(String errorMessage, Exception ex) {
        super(errorMessage, ex);
    }

}
