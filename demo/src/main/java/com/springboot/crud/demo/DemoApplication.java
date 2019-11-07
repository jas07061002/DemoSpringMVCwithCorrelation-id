package com.springboot.crud.demo;

import com.springboot.crud.demo.filter.CorrelationHeaderFilter;
import net.saliman.spring.request.correlation.api.EnableRequestCorrelation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Arrays;

@EnableRequestCorrelation
@SpringBootApplication
@EnableJpaRepositories(basePackages="com.springboot.crud.demo.repository")
@EnableTransactionManagement
@EntityScan(basePackages="com.springboot.crud.demo.model")
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public FilterRegistrationBean correlationHeaderFilter() {
        FilterRegistrationBean filterRegBean = new FilterRegistrationBean();
        filterRegBean.setFilter(new CorrelationHeaderFilter());
        filterRegBean.setUrlPatterns(Arrays.asList("/*"));

        return filterRegBean;
    }


}
