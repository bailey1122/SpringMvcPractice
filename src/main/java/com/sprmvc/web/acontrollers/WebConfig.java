package main.java.com.sprmvc.web.acontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Method;

@Configuration
@ComponentScan("main.java.com.sprmvc.web.acontrollers")
public class WebConfig {

//    @Autowired
//    public void setHandlerMapping(RequestMappingHandlerMapping mapping, UserHandler handler)
//            throws NoSuchMethodException {
//
//        RequestMappingInfo info = RequestMappingInfo
//                .paths("/user/{id}").methods(RequestMethod.GET).build();
//
//        Method method = UserHandler.class.getMethod("getUser", Long.class);
//
//        mapping.registerMapping(info, handler, method);
//    }
}
