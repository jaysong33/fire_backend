package com.fire.config;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by syj on 2018/7/24.
 *
 * Druid 配置
 */
@Configuration
public class DruidConfig {

    /**
     * 注册一个ServletRegistrationBean
     */
    @Bean
    public ServletRegistrationBean servletRegistrationBean(){
        ServletRegistrationBean bean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
        // 添加初始化参数
        // 白名单
        bean.addInitParameter("allow", "127.0.0.1");
        // 黑名单: 配置了共同值时，deny优先于allow，如果满足deny，提示：Sorry，you are not permitted to view this page.
        bean.addInitParameter("deny", "192.168.0.114");
        // 登录查看信息的账号密码
        bean.addInitParameter("loginUsername", "admin");
        bean.addInitParameter("loginPassword", "123456");
        // 是否能够重置数据
        bean.addInitParameter("resetEnable", "false");
        return bean;
    }

    /**
     * 注册一个FilterRegistrationBean
     */
    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean bean = new FilterRegistrationBean<>(new WebStatFilter());
        // 添加过滤规则
        bean.addUrlPatterns("/*");
        // 添加不需要忽略的格式信息
        bean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return bean;
    }
}
