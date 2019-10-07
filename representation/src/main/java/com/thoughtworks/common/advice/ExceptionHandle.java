package com.thoughtworks.common.advice;

import com.thoughtworks.common.BaseException;
import com.thoughtworks.common.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;

@Slf4j
@ControllerAdvice("com.thoughtwors")
public class ExceptionHandle {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public CommonResponse handArgumentValidateException(MethodArgumentNotValidException e) {
        log.error(" MethodArgumentNotValidException error:{}", e);
        return CommonResponse.fail(401, e.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public CommonResponse handIllegalArgumentException(IllegalArgumentException e) {
        log.error(" IllegalArgumentException error:{}", e);
        return CommonResponse.fail(401, e.getMessage());
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public CommonResponse handMissingServletRequestParameterException(MissingServletRequestParameterException e) {
        log.error(" MissingServletRequestParameterException error:{}", e);
        return CommonResponse.fail(401, e.getMessage());
    }

    @ExceptionHandler(BaseException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public CommonResponse handBaseException(BaseException e) {
        log.error(" BaseException error:{}", e);
        return CommonResponse.fail(401, e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public CommonResponse handBaseException(Exception e) {
        log.error(" Exception error:{}", e);
        return CommonResponse.fail(401, e.getMessage());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public CommonResponse handConstraintViolationException(ConstraintViolationException e) {
        log.error(" ConstraintViolationException error:{}", e);
        return CommonResponse.fail(401, e.getMessage());
    }
}