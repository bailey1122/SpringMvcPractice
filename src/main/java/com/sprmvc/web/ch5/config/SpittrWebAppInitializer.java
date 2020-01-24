package com.sprmvc.web.ch5.config;

import com.sprmvc.web.ch5.filters.MyFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import javax.servlet.*;

public class SpittrWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { RootConfig.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { WebConfigCh.class };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/", "*.service", "/ws/*" };
    }

    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        registration.setMultipartConfig(
                new MultipartConfigElement("c:\\upload",
                        1111111111, 1111111111, 0));
    }

//    @Override
//    protected Filter[] getServletFilters() {
//        return new Filter[] {new MyFilter()};
//    }
}
