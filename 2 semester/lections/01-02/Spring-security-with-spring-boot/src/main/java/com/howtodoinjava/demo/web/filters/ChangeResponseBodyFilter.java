package com.howtodoinjava.demo.web.filters;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;

@WebFilter("/public")
public class ChangeResponseBodyFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        ContentCachingResponseWrapper responseWrapper = new ContentCachingResponseWrapper((HttpServletResponse) response);

        chain.doFilter(request, responseWrapper);

        byte[] originalData = responseWrapper.getContentAsByteArray();

        // Modify the original data
        String newData = new String(originalData);
        newData += " - modified";

        // Write the data into the output stream
        response.setContentLength(newData.length());
        response.getOutputStream().write(newData.getBytes());

    }
}
