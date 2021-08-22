package Week3.Day2.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CommonsRequestLoggingFilter;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Configuration
public class ScopeAppConfig implements WebMvcConfigurer {

    private static final Logger LOGGER = LoggerFactory.getLogger(ScopeAppConfig.class);



    @Bean
    public HandlerInterceptor requestLogInterceptor(){
        return new HandlerInterceptor() {
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
                LOGGER.info("interceptor basladı: {}", request.getRequestURI());
                return HandlerInterceptor.super.preHandle(request, response, handler);
            }

            @Override
            public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
                LOGGER.info("interceptor bitti: {}", request.getRequestURI());
                HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
            }
        };
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        WebMvcConfigurer.super.addInterceptors(registry);
        registry.addInterceptor(requestLogInterceptor());
    }

    @Bean
    public CommonsRequestLoggingFilter commonsRequestLoggingFilter(){
        CommonsRequestLoggingFilter filter = new CommonsRequestLoggingFilter();
        filter.setIncludeHeaders(Boolean.TRUE);
        filter.setIncludeQueryString(Boolean.TRUE);
        return filter;
    }

    /*@Bean
    public ELearningService eLearningService(){return new ELearningServiceImpl(new InMemoryContentCache()); }

    @Bean
    public VideoService videoService(){return new VideoServiceImpl(new InMemoryContentCache()); }

    @Bean
    public ContentCache contentCache(){return new InMemoryContentCache(); }*/

}
