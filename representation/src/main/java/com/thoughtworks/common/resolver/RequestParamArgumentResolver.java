package com.thoughtworks.common.resolver;

import com.fasterxml.jackson.databind.ObjectMapper;
import jdk.internal.joptsimple.internal.Strings;
import org.springframework.core.MethodParameter;
import org.springframework.util.Assert;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.Validator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class RequestParamArgumentResolver implements HandlerMethodArgumentResolver {

    public RequestParamArgumentResolver(ObjectMapper objectMapper, Validator validator) {
        this.objectMapper = objectMapper;
        this.validator = validator;
    }

    private final ObjectMapper objectMapper;

    private final Validator validator;

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.hasParameterAnnotation(RequestParam.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter,
                                  ModelAndViewContainer modelAndViewContainer,
                                  NativeWebRequest webRequest,
                                  WebDataBinderFactory webDataBinderFactory) throws Exception {

        HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);
        Assert.state(request != null, "no http requet");

        Class<?> containingClass = parameter.getParameterType();

        boolean needValid = parameter.hasParameterAnnotation(Valid.class);

        if ("GET".equalsIgnoreCase(request.getMethod())) {
            Map<String, String[]> paramMap = request.getParameterMap();
            Map<String, String> result = new LinkedHashMap(paramMap);
            for (Map.Entry<String, String[]> entry : paramMap.entrySet()) {
                if (entry.getValue().length > 0) {
                    result.put(entry.getKey(), Strings.join(entry.getValue(), ","));
                }
            }

            return validModel(objectMapper.readValue(objectMapper.writeValueAsBytes(result), containingClass), needValid);

        }
        return validModel(objectMapper.readValue(request.getInputStream(), containingClass), needValid);
    }

    private Object validModel(Object model, boolean needValid) {
        if (needValid && Objects.nonNull(model)) {
            Set<ConstraintViolation<Object>> violations = validator.validate(model);
            if (!violations.isEmpty()) {
                throw new ConstraintViolationException(violations);
            }
        }
        return model;
    }


}
