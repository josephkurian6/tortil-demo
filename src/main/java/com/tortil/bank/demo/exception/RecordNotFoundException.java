package com.tortil.bank.demo.exception;

import com.tortil.bank.demo.model.ErrorResponse;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import java.util.Date;

/**
 * Represent resource/records not found exceptions
 * @Date 6/9/2021
 */
@Getter
public class RecordNotFoundException extends RuntimeException {

    static final long serialVersionUID = -3387516993124229948L;

    private final ErrorResponse errorResponse;
    public RecordNotFoundException(String message) {
        super(message);
        errorResponse = ErrorResponse.builder().error("Record NotFound Exception")
                .message(message).timestamp(new Date()).status(HttpStatus.NOT_FOUND).build();
    }
}
