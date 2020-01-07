//package com.sprmvc.web.dispservlet;
//
//import org.springframework.web.context.WebApplicationContext;
//import org.springframework.web.context.support.XmlWebApplicationContext;
//import org.springframework.web.filter.CharacterEncodingFilter;
//import org.springframework.web.filter.HiddenHttpMethodFilter;
//import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;
//
//import javax.servlet.Filter;
//import javax.servlet.MultipartConfigElement;
//import javax.servlet.ServletRegistration;
//
//public class MyWebAppInitializer2 extends AbstractDispatcherServletInitializer {
//    @Override
//    protected WebApplicationContext createServletApplicationContext() {
//        return null;
//    }
//
//    @Override
//    protected WebApplicationContext createRootApplicationContext() {
//        XmlWebApplicationContext cxt = new XmlWebApplicationContext();
//        cxt.setConfigLocation("main/webapp/WEB-INF/dispatcher-config.xml");
//        return cxt;
//    }
//
//    @Override
//    protected String[] getServletMappings() {
//        return new String[] {"/"};
//    }
//
//    @Override
//    protected Filter[] getServletFilters() {
//        return new Filter[] {
//                new HiddenHttpMethodFilter(), new CharacterEncodingFilter() };
//    }
//
//    @Override
//    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
//        registration.setInitParameter("enableLoggingRequestDetails", "true");
//        registration.setMultipartConfig(new MultipartConfigElement("/tmp"));
//    }
//}
