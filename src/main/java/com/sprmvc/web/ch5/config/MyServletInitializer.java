//package com.sprmvc.web.ch5.config;
//
//import com.sprmvc.web.ch5.filters.MyFilter;
//import com.sprmvc.web.ch5.servlets.MyServlet;
//import org.springframework.web.WebApplicationInitializer;
//
//import javax.servlet.ServletContext;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRegistration;
//
//public class MyServletInitializer implements WebApplicationInitializer {
//
//    @Override
//    public void onStartup(ServletContext servletContext) throws ServletException {
//        ServletRegistration.Dynamic myServlet =
//                servletContext.addServlet("myServlet", MyServlet.class);
//        myServlet.addMapping("/custom/**");
//
//        javax.servlet.FilterRegistration.Dynamic filter =
//                servletContext.addFilter("myFilter", MyFilter.class);
//        filter.addMappingForUrlPatterns(null, false, "/custom/**");
//    }
//}
