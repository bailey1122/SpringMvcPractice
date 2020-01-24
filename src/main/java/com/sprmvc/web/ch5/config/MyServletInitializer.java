//package com.sprmvc.web.ch5.config;
//
//import com.sprmvc.web.ch5.filters.MyFilter;
//import com.sprmvc.web.ch5.services.AppConfig;
//import com.sprmvc.web.ch5.servlets.MyServlet;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.web.WebApplicationInitializer;
//import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
//import org.springframework.web.servlet.DispatcherServlet;
//import org.springframework.web.servlet.ViewResolver;
////import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
////import org.springframework.web.servlet.view.tiles3.TilesViewResolver;
//
//import javax.servlet.*;
//
//public class MyServletInitializer implements WebApplicationInitializer {
//
//    @Override
//    public void onStartup(ServletContext servletContext) throws ServletException {
//        AnnotationConfigWebApplicationContext ctx =
//                new AnnotationConfigWebApplicationContext();
//        ctx.register(AppConfig.class);
//        ctx.setServletContext(servletContext);
//        ServletRegistration.Dynamic servlet =
//                servletContext.addServlet("springDispatcherServlet",
//                        new DispatcherServlet(ctx));
//
//        servlet.setLoadOnStartup(1);
//        servlet.addMapping("/");
//
//
//
////        DispatcherServlet ds = new DispatcherServlet();
////        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("appServletTwo", ds);
////        dispatcher.setLoadOnStartup(1);
////        dispatcher.addMapping("/");
////        dispatcher.addMapping("*.service");
////        ServletRegistration.Dynamic registration = servletContext.addServlet("appServlet", ds);
////        registration.addMapping("/");
////        registration.setMultipartConfig(
////                new MultipartConfigElement("/tmp/spittr/uploads"));
////
////        ServletRegistration.Dynamic myServlet =
////                servletContext.addServlet("myServlet", MyServlet.class);
////        myServlet.addMapping("/custom/**");
////
////        javax.servlet.FilterRegistration.Dynamic filter =
////                servletContext.addFilter("myFilter", MyFilter.class);
////        filter.addMappingForUrlPatterns(null, false, "/custom/**");
//    }
//}
