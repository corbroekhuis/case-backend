package org.eijsink.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

//@Component
//@Order(1)
public class JsonFilter implements Filter {

    protected static final Logger logger = LogManager.getLogger();

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        if(isPutOrPost( request)) {
            RequestWrapper requestWrapper = new RequestWrapper((HttpServletRequest) request);
            System.out.println(requestWrapper.getBody());
            chain.doFilter(requestWrapper, response);
        }else{
            chain.doFilter(request, response);
        }

    }

    private boolean isPutOrPost( ServletRequest request){
        if( ((HttpServletRequest)request).getMethod().toUpperCase().equals("POST")){
            return true;
        }
        if( ((HttpServletRequest)request).getMethod().toUpperCase().equals("PUT")){
            return true;
        }
        return false;
    }
    // other methods
}
