package com.epam.mentoring.pattern.service.exception;

public class PaymentServiceException extends Exception {

    public PaymentServiceException() {
        super();
    }

    public PaymentServiceException(Exception ex) {
        super(ex);
    }

    public PaymentServiceException(String errorMessage) {
        super(errorMessage);
    }

    public PaymentServiceException(String errorMessage, Exception ex) {
        super(errorMessage, ex);
    }

}
