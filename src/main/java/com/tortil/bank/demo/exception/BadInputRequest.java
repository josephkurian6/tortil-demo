package com.tortil.bank.demo.exception;

import com.tortil.bank.demo.model.ErrorResponse;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import java.util.Date;

/**
 * Represent client side bad request exceptions
 * @Date 6/9/2021
 */
@Getter
public class BadInputRequest extends RuntimeException {

    static final long serialVersionUID = -7034897190745766939L;

    private final ErrorResponse errorResponse;
    public BadInputRequest(String message) {
        super(message);
        errorResponse = ErrorResponse.builder().error("Bad Input Request")
                .message(message).timestamp(new Date()).status(HttpStatus.BAD_REQUEST).build();
    }
}
