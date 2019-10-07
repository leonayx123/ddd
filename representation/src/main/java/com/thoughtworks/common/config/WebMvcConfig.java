package com.thoughtworks.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.xml.validation.Validator;
import java.util.List;
import java.util.Objects;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    private final ObjectMapper mapper;
    private final Validator validator;

    public WebMvcConfig(ObjectMapper mapper, Validator validator) {
        this.mapper = mapper;
        this.validator = validator;
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new RequestParamArgumentResolver(mapper, validator));
    }
}
