package org.eijsink.configuration;

import org.eijsink.filter.JsonFilter;
import org.eijsink.filter.TransactionFilter;
import org.eijsink.interceptor.RequestInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyConfig implements WebMvcConfigurer {

    @Autowired
    RequestInterceptor requestInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(requestInterceptor).addPathPatterns("/**");
    }


    @Bean
    public FilterRegistrationBean<TransactionFilter> loggingFilter(){
        FilterRegistrationBean<TransactionFilter> registrationBean
                = new FilterRegistrationBean<>();

        registrationBean.setFilter(new TransactionFilter());
        registrationBean.addUrlPatterns("/api/item/*");
        registrationBean.setOrder(2);

        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean<JsonFilter> jsonFilter(){
        FilterRegistrationBean<JsonFilter> registrationBean
                = new FilterRegistrationBean<>();

        registrationBean.setFilter(new JsonFilter());
        registrationBean.addUrlPatterns("/api/ober/*");
        registrationBean.setOrder(1);

        return registrationBean;
    }

}
