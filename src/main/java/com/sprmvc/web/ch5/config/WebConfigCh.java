package com.sprmvc.web.ch5.config;

import com.sprmvc.web.ch5.services.SpitterService;
import com.sprmvc.web.ch5.services.SpitterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.remoting.caucho.BurlapProxyFactoryBean;
import org.springframework.remoting.caucho.BurlapServiceExporter;
import org.springframework.remoting.caucho.HessianProxyFactoryBean;
import org.springframework.remoting.caucho.HessianServiceExporter;
import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;
import org.springframework.remoting.httpinvoker.HttpInvokerServiceExporter;
import org.springframework.remoting.jaxws.JaxWsPortProxyFactoryBean;
import org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;
import org.springframework.remoting.rmi.RmiServiceExporter;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.sprmvc.web.ch5.webmvc", "com.sprmvc.web.ch5.data", "com.sprmvc.web.ch5.services", "com.sprmvc.web.ch5.rest"})
public class WebConfigCh implements WebMvcConfigurer {

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.favorPathExtension(true).
        favorParameter(false).
        ignoreAcceptHeader(false).
            defaultContentType(MediaType.TEXT_HTML);
//        mediaType("xml", MediaType.APPLICATION_XML).
//        mediaType("json", MediaType.APPLICATION_JSON);
//        defaultContentType(MediaType.TEXT_XML);
//        defaultContentType(MediaType.APPLICATION_JSON);
//        configurer.defaultContentType(MediaType.APPLICATION_JSON);
    }

    @Bean
    public ViewResolver cnViewResolver(ContentNegotiationManager cnm) {
//        return new ContentNegotiatingViewResolver();
        ContentNegotiatingViewResolver cnvr = new ContentNegotiatingViewResolver();
        cnvr.setContentNegotiationManager(cnm);
        return cnvr;
    }

    @Bean
    public ViewResolver beanNameViewResolver() {
        return new BeanNameViewResolver();
    }

    @Bean
    public View spittle() {
        return new MappingJackson2JsonView();
    }


    @Bean
    public SimpleJaxWsServiceExporter jaxWsServiceExporter() {
//        return new SimpleJaxWsServiceExporter();
        SimpleJaxWsServiceExporter exporter =
                new SimpleJaxWsServiceExporter();
        exporter.setBaseAddress("http://localhost:8888/SpringMvcPractice/services");
        return exporter;
    }


//    @Bean
//    public OrderService orderService() {
//        return new OrderServiceImpl();
//    }

//    @Bean(name = "/OrderService")
//    public BurlapServiceExporter exporter() {
//        BurlapServiceExporter hse = new BurlapServiceExporter();
//        hse.setService(orderService());
//        hse.setServiceInterface(OrderService.class);
//        return hse;
//    }

    @Bean
    public SpitterService spitterService() {
        return new SpitterServiceImpl();
    }

////    @Bean(name = "/SpitterService")
//    @Bean(name = "/spitter.service")
//    public BurlapServiceExporter
//            burlapServiceExportedSpitterService() {
//        BurlapServiceExporter exporter = new BurlapServiceExporter();
//        exporter.setService(spitterService());
//        exporter.setServiceInterface(SpitterService.class);
//        return exporter;
//    }

    //    @Bean(name = "/SpitterService")
    @Bean(name = "/spitter.service")
    public HttpInvokerServiceExporter
    httpExportedSpitterService(SpitterService service) {
        HttpInvokerServiceExporter exporter =
                new HttpInvokerServiceExporter();
        exporter.setService(service);
        exporter.setServiceInterface(SpitterService.class);
        return exporter;
    }


//    @Bean
//    public ViewResolver viewResolver() {
//        InternalResourceViewResolver resolver =
//                new InternalResourceViewResolver();
//        resolver.setPrefix("/WEB-INF/views/");
//        resolver.setSuffix(".jsp");
//        resolver.setViewClass(JstlView.class);
////        resolver.setExposeContextBeansAsAttributes(true);
//        return resolver;
//    }

    @Bean
    public TilesConfigurer tilesConfigurer() {
        TilesConfigurer tiles = new TilesConfigurer();
        tiles.setDefinitions(new String[] {
                "/WEB-INF/layout/tiles.xml"
        });
        tiles.setCheckRefresh(true);
        return tiles;
    }

    @Bean
    public ViewResolver tilesViewResolver() {
        return new TilesViewResolver();
    }



    @Bean
    public MultipartResolver multipartResolver() throws IOException {
        return new StandardServletMultipartResolver();
//        return new CommonsMultipartResolver();
//        CommonsMultipartResolver multipartResolver =
//                new CommonsMultipartResolver();
//        multipartResolver.setUploadTempDir(
//                new FileSystemResource("/tmp/spittr/uploads"));
//        multipartResolver.setMaxUploadSize(2097152);
//        multipartResolver.setMaxInMemorySize(0);
//        return multipartResolver;
    }


//    @Bean
//    public ViewResolver thymeleafViewResolver(
//            SpringTemplateEngine templateEngine) {
//        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
//        viewResolver.setTemplateEngine(templateEngine);
//        return viewResolver;
//    }
//
//    @Bean
//    public SpringTemplateEngine thymeleafTemplateEngine() {
//        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
//        templateEngine.setTemplateResolver(thymeleafTemplateResolver());
//        return templateEngine;
//    }
//
//    @Bean
//    public SpringResourceTemplateResolver thymeleafTemplateResolver() {
//        SpringResourceTemplateResolver templateResolver
//                = new SpringResourceTemplateResolver();
//        templateResolver.setPrefix("/WEB-INF/templates/");
//        templateResolver.setSuffix(".html");
//        templateResolver.setTemplateMode("HTML5");
//        return templateResolver;
//    }


    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}

