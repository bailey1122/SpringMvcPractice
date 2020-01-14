package com.sprmvc.web.ch5.config;

import com.sprmvc.web.ch5.services.SpitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
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
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
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
@ComponentScan(basePackages = {"com.sprmvc.web.ch5.webmvc", "com.sprmvc.web.ch5.data", "com.sprmvc.web.ch5.services"})
public class WebConfigCh implements WebMvcConfigurer {

//    @Bean
//    public SimpleJaxWsServiceExporter jaxWsServiceExporter() {
////        return new SimpleJaxWsServiceExporter();
//        SimpleJaxWsServiceExporter exporter =
//                new SimpleJaxWsServiceExporter();
//        exporter.setBaseAddress("http://localhost:8888/services/");
//        return exporter;
//    }
//
//    @Bean
//    public JaxWsPortProxyFactoryBean spitterService() throws MalformedURLException {
//        JaxWsPortProxyFactoryBean proxy = new JaxWsPortProxyFactoryBean();
//        URL url = new URL("http://localhost:8080/services/SpitterService?wsdl");
//        proxy.setWsdlDocumentUrl(url);
//        proxy.setServiceName("spitterService");
//        proxy.setPortName("spitterServiceHttpPort");
//        proxy.setServiceInterface(SpitterService.class);
//        proxy.setNamespaceUri("http://spitter.com");
//        return proxy;
//    }


    @Bean
    @Autowired
    public HttpInvokerServiceExporter
            httpExportedSpitterService(SpitterService spitterService) {
        HttpInvokerServiceExporter exporter = new HttpInvokerServiceExporter();
        exporter.setService(spitterService);
        exporter.setServiceInterface(SpitterService.class);
        return exporter;
    }

    @Bean
    public HandlerMapping httpInvokerMapping() {
        SimpleUrlHandlerMapping mapping = new SimpleUrlHandlerMapping();
        Properties mappings = new Properties();
        mappings.setProperty("/spitter.service", "httpExportedSpitterService");
        mapping.setMappings(mappings);
        return mapping;
    }

    @Bean
    public HttpInvokerProxyFactoryBean spitterService() {
        HttpInvokerProxyFactoryBean proxy = new HttpInvokerProxyFactoryBean();
        proxy.setServiceUrl("http://localhost:8080/Spitter/spitter.service");
        proxy.setServiceInterface(SpitterService.class);
        return proxy;
    }


//    @Bean
//    @Autowired
//    public HessianServiceExporter
//            hessianExportedSpitterService(SpitterService spitterService) {
//        HessianServiceExporter exporter = new HessianServiceExporter();
//        exporter.setService(spitterService);
//        exporter.setServiceInterface(SpitterService.class);
//        return exporter;
//    }
//
//    @Bean
//    public HandlerMapping hessianMapping() {
//        SimpleUrlHandlerMapping mapping = new SimpleUrlHandlerMapping();
//        Properties mappings = new Properties();
//        mappings.setProperty("/spitter.service", "hessianExportedSpitterService");
//        mapping.setMappings(mappings);
//        return mapping;
//    }
//
//    @Bean
//    public HessianProxyFactoryBean spitterService() {
//        HessianProxyFactoryBean proxy = new HessianProxyFactoryBean();
//        proxy.setServiceUrl("http://localhost:8080/Spitter/spitter.service");
//        proxy.setServiceInterface(SpitterService.class);
//        return proxy;
//    }


//    @Bean
//    @Autowired
//    public BurlapServiceExporter
//            burlapServiceExportedSpitterService(SpitterService spitterService) {
//        BurlapServiceExporter exporter = new BurlapServiceExporter();
//        exporter.setService(spitterService);
//        exporter.setServiceInterface(SpitterService.class);
//        return exporter;
//    }
//
//    @Bean
//    public HandlerMapping burlapMapping() {
//        SimpleUrlHandlerMapping mapping = new SimpleUrlHandlerMapping();
//        Properties mappings = new Properties();
//        mappings.setProperty("/spitter.service", "burlapServiceExportedSpitterService");
//        mapping.setMappings(mappings);
//        return mapping;
//    }
//
//    @Bean
//    public BurlapProxyFactoryBean spitterService() {
//        BurlapProxyFactoryBean proxy = new BurlapProxyFactoryBean();
//        proxy.setServiceUrl("http://localhost:8080/Spitter/spitter.service");
//        proxy.setServiceInterface(SpitterService.class);
//        return proxy;
//    }


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
//
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
