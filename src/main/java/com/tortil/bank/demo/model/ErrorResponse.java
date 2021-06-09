package com.tortil.bank.demo.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.Date;

/**
 * Model for error response
 */
@Data
@Builder
public class ErrorResponse implements Serializable {

    static final long serialVersionUID = -2405172041950251807L;

    private String error;

    private String message;

    private Date timestamp;

    private HttpStatus status;
}
