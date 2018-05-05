package com.example.demo.configuration;

import com.example.demo.interceptor.TestInterceptor;
import com.example.demo.interceptor.TestInterceptor2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Author: zouqinjia
 * Description:
 * Date:2018/4/27 15:37
 **/
@Configuration
@EnableWebMvc
@EnableScheduling
public class MVCConfig extends WebMvcConfigurerAdapter {

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

        registry.addResourceHandler("/static/**","/view/**")// 对外暴露的访问路径
                .addResourceLocations("classpath:/static/","classpath:/view/");// 文件放置目录
//        registry.addResourceHandler("/view/**")// 对外暴露的访问路径
//                .addResourceLocations("classpath:/view/");// 文件放置目录
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

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/error").setViewName("error");
        registry.addViewController("/toUpload").setViewName("upload");
        registry.addViewController("/async").setViewName("async");
        registry.addViewController("/sse").setViewName("/sse");
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(testInterceptor());
//        registry.addInterceptor(testInterceptor2()).addPathPatterns().order(1);
    }

//    @Bean
//    public MultipartResolver multipartResolver(){
//
//        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
//        multipartResolver.setMaxUploadSize(1024000);
//        return multipartResolver;
//    }

    @Bean
    public HandlerInterceptor testInterceptor2(){

        return new TestInterceptor2();
    }

    @Bean
    public HandlerInterceptor testInterceptor(){

        return new TestInterceptor();
    }

    @Bean
    public TaskExecutor taskExecutor(){

        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(10);
        threadPoolTaskExecutor.setQueueCapacity(15);
        threadPoolTaskExecutor.setMaxPoolSize(20);

        return threadPoolTaskExecutor;
    }
}
