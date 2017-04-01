package com.muddworks.support.api;

import com.ibm.watson.developer_cloud.service.exception.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created on 4/1/17.
 */
@ControllerAdvice
public class GlobalResourceExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> defaultHandler() {
        return new ResponseEntity<>("An error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<?> unauthorizedWatsonHandler() {
        return new ResponseEntity<>("Please check your watson credentials", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
