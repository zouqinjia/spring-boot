package com.example.demo.configuration;

import com.example.demo.interceptor.TestInterceptor;
import com.example.demo.interceptor.TestInterceptor2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Author: zouqinjia
 * Description:
 * Date:2018/4/27 15:37
 **/
@Configuration
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

        registry.addResourceHandler("/static/**")// 对外暴露的访问路径
                .addResourceLocations("classpath:/static/**");// 文件放置目录
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
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(testInterceptor2());
        registry.addInterceptor(testInterceptor());
    }

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
