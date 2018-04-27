package com.example.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Author: zouqinjia
 * Description:
 * Date:2018/4/27 15:37
 **/
public class MVCConfig implements WebMvcConfigurer {

//    @Bean
//    public HttpMessageConverters customConverters() {
//        HttpMessageConverter<?> additional = new
//        HttpMessageConverter<?> another = ...
//        return new HttpMessageConverters(additional, another);
//    }

    /**
     * 添加静态资源
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/static/**")// 为基于指定的URL路径模式的静态资源添加一个资源处理程序。
                .addResourceLocations("classpath:/static/**");// 为静态内容添加一个或多个资源位置。
    }

    /**
     * 视图解析器
     * @return InternalResourceViewResolver
     */
    @Bean
    public InternalResourceViewResolver resourceViewResolver(){

        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/view/");
        viewResolver.setSuffix(".html");
        viewResolver.setViewClass(InternalResourceView.class);

        return viewResolver;
    }


}
