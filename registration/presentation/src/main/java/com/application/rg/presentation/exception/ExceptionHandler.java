package com.application.rg.presentation.exception;

import com.application.rg.domain.exception.BusinessException;
import com.application.rg.domain.exception.NotFoundException;
import com.application.rg.presentation.ResponseViewModel;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {
    private static final String DEFAULT_NOT_FOUND_MESSAGE = "Resource Not Found";
    private  static final String DEFAULT_BUSINESS_EXCEPTION_MESSAGE = "Some logical error occurred";

    @org.springframework.web.bind.annotation.ExceptionHandler
    @ResponseBody
    public ResponseViewModel handleControllerException(
            final HttpServletRequest request, final Throwable throwable
            ){

        if (throwable instanceof NotFoundException) {
            return getErrorResponseForStatus(throwable, HttpStatus.NOT_FOUND, DEFAULT_NOT_FOUND_MESSAGE);
        } else if (throwable instanceof BusinessException){
            return getErrorResponseForStatus(throwable, HttpStatus.CONFLICT, DEFAULT_BUSINESS_EXCEPTION_MESSAGE);
        } else{
            return getDefaultErrorResponse(throwable);
        }
    }

    private ResponseViewModel getErrorResponseForStatus(
            Throwable ex, HttpStatus httpStatus, String defaultMessage
    ) {
        String message = ExceptionMessage.errors.getOrDefault(ex.getClass(), defaultMessage);
        return ResponseViewModel.builder()
                .hasError(true)
                .message(message)
                .data(null)
                .build();
    }

    private ResponseViewModel getDefaultErrorResponse(final Throwable throwable) {
        logger.fatal("Unhandled exception", throwable);
        return ResponseViewModel.builder()
                .hasError(true)
                .message("Oops! something really bad happened and we couldn't recover info.")
                .data(null)
                .build();
    }

}
