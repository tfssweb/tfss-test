package com.zhongziyue.video.web.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class VideoWebAppConfigureration implements WebMvcConfigurer {
    @Value("${videos.vpath}")
    private String vpath;

    @Value("${videos.rpath}")
    private String rpath;
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler( vpath + "**").addResourceLocations("file:" + rpath);
    }
}