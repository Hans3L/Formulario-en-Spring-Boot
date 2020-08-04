package com.creativity.registrymicroservice.component;

import com.creativity.registrymicroservice.entity.LogEntity;
import com.creativity.registrymicroservice.repository.LogRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Component("requestTimeInterceptor")
public class RequestTimeInterceptor extends HandlerInterceptorAdapter {

    Logger LOGGER = LogManager.getLogger(RequestTimeInterceptor.class);

    @Autowired
    @Qualifier("logRepository")
    private LogRepository logRepository;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
       request.setAttribute("startTime",System.currentTimeMillis());
       return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        long startTime = (long) request.getAttribute("startTime");
        String url = request.getRequestURL().toString();
        Authentication Auth = SecurityContextHolder.getContext().getAuthentication();
        String username = "";
        if (null != Auth && Auth.isAuthenticated())
            username = Auth.getName();

        logRepository.save(new LogEntity(new Date(),Auth.getDetails().toString(),username,url));
        LOGGER.info("REQUEST URL: " + request.getRequestURL() + " -- TOTAL TIME: " + (System.currentTimeMillis() - startTime) + " ms");
    }
}
