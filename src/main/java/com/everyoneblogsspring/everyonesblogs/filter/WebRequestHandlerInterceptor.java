package com.everyoneblogsspring.everyonesblogs.filter;

import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;
@Component
public class WebRequestHandlerInterceptor implements WebRequestInterceptor {

    @Override
    public void preHandle(WebRequest request) throws Exception {

        throw new UnsupportedOperationException("Unimplemented method 'preHandle'");
    }

    @Override
    public void postHandle(WebRequest request, ModelMap model) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'postHandle'");
    }

    @Override
    public void afterCompletion(WebRequest request, Exception ex) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'afterCompletion'");
    }

}
