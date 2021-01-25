package meli.challenge.demo.configuration;

import meli.challenge.demo.controller.MutantController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

@Configuration
public class AuditConfig implements WebMvcConfigurer {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuditConfig.class.getName());

    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new HandlerInterceptorAdapter() {

            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
                if (handler instanceof HandlerMethod) {
                    HandlerMethod handlerMethod = (HandlerMethod) handler;
                    Method method = handlerMethod.getMethod();
                    LOGGER.info("{} - {} - method '{}' on controller '{}' with params {}",
                            request.getMethod(), request.getRequestURI(), method.getName(),
                            handlerMethod.getBean().getClass(), request.getQueryString() != null ? request.getQueryString() : ""
                    );
                }
                return true;
            }
        });
    }

}
