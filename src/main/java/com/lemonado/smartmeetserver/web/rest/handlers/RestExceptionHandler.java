package com.lemonado.smartmeetserver.web.rest.handlers;

import com.lemonado.smartmeetserver.core.data.exceptions.*;
import com.lemonado.smartmeetserver.web.rest.models.auth.*;
import com.lemonado.smartmeetserver.web.rest.models.responses.Response;
import com.lemonado.smartmeetserver.web.rest.models.responses.ResponseFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.mail.AuthenticationFailedException;

@ControllerAdvice
public final class RestExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {
            AccessDeniedException.class,
            AuthenticationFailedException.class,
            InvalidTokenException.class,
            LoginFailedException.class,
            TokenBlockedException.class,
    })
    protected ResponseEntity<?> handleForbidden(Exception exception, WebRequest request) {
        var response = ResponseFactory.createForbidden(exception);

        return handleException(exception, response, HttpStatus.FORBIDDEN, request);
    }

    @ExceptionHandler(value = {
            RoleNotFoundException.class,
            UserNotFoundException.class,
            RegistrationCodeNotFoundException.class,
    })
    protected ResponseEntity<?> handleNotFound(Exception exception, WebRequest request) {
        var response = ResponseFactory.createNotFound(exception);

        return handleException(exception, response, HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(value = {
            CanNotCreateUserException.class,
            CanNotSendMailException.class,
            UserAlreadyExistsException.class,
            UserIsBlockedException.class,
            ActionOnAdminRoleException.class,
    })
    protected ResponseEntity<?> handleConflict(Exception exception, WebRequest request) {
        var response = ResponseFactory.createConflict(exception);

        return handleException(exception, response, HttpStatus.CONFLICT, request);
    }

    private ResponseEntity<?> handleException(Exception exception, Response<?> response, HttpStatus status, WebRequest request) {
        return handleExceptionInternal(exception, response, new HttpHeaders(), status, request);
    }
}
