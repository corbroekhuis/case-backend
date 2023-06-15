package org.eijsink.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;
import java.util.Enumeration;

@Component
public class RequestInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){

        System.out.println("PreHandle: ");

        // Toon alle request parameters
        Enumeration<String> parameterNames = request.getParameterNames();
        while( parameterNames.hasMoreElements()){
            String name = parameterNames.nextElement();
            System.out.println( "Parameter: " + request.getParameter( name));

        }

        // Toon alle request headers
        Enumeration<String> headerNames = request.getHeaderNames();
        while( headerNames.hasMoreElements()){
            String name = headerNames.nextElement();
            System.out.println( "Header: " + request.getHeader( name));

        }

        return true;

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView){

        System.out.println("PostHandle: ");
        // Toon alle response headers
        Collection<String> headerNames = response.getHeaderNames();
        for( String name: headerNames){
            System.out.println( "Header: " + request.getHeader( name));

        }

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception exception){

        System.out.println("AfterCompletion");

    }

}
