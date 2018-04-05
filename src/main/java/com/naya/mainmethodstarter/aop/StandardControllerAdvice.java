package com.naya.mainmethodstarter.aop;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author Evgeny Borisov
 */
@ControllerAdvice
public class StandardControllerAdvice implements ResponseBodyAdvice {
    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {

        return methodParameter.getMethod().getDeclaringClass().isAnnotationPresent(StadnardRestController.class);
    }

    @Nullable
    @Override
    public Object beforeBodyWrite(@Nullable Object object, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        return new BodyWrapper(object);
    }
}
