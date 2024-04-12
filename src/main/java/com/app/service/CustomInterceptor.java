package com.app.service;

/**
 * Created by: arif hosain
 * Mail: arif@innoweb.co
 * Created at : 4/12/2024
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class CustomInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        final String contPath = request.getContextPath();
        String urlPrefix = "http://" + request.getServerName() + ":" + request.getServerPort() + contPath;
        System.out.println(urlPrefix);
        System.out.println("===================");
        // Check if the user is already logged in
        boolean isLoggedIn = checkUserAuthentication(request);
        if (isLoggedIn) {
            // Redirect authenticated users away from the login page
            response.sendRedirect("/welcome");
            return false; // Return false to stop further processing
        }
        return true; // Allow the request to proceed
    }

    private boolean checkUserAuthentication(HttpServletRequest request) {
        // Implement your authentication logic here
        // For example, check if a user session exists
        // Return true if the user is authenticated, false otherwise
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        // This method is empty, but you can override it if needed
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                Exception ex) throws Exception {
        // This method is empty, but you can override it if needed
    }
}
