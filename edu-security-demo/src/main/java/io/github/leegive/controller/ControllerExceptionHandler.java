package io.github.leegive.controller;

import io.github.leegive.exception.UserNotExistException;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Map;

/**
 * TODO
 *
 * @author leegive
 */
@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(UserNotExistException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, Object> handleUserNotExistException(UserNotExistException e) {
        Map<String, Object> result = new HashedMap();
        result.put("id", e.getId());
        result.put("message", e.getMessage());
        return result;
    }

}
