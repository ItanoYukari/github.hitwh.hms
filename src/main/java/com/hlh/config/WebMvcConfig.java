package com.hlh.config;

import javax.sql.DataSource;

import org.apache.ibatis.plugin.Interceptor;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.hlh.interceptor.MybatisInterceptor;
import com.hlh.interceptor.PageInterceptor;
import com.hlh.interceptor.SqlSessionFactory;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
	@Autowired
	private PageInterceptor myInterceptor;
	
	@Autowired
	private MybatisInterceptor m;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		registry.addInterceptor(myInterceptor)
        // 设置拦截所有路径地址
        .addPathPatterns("/**")
        // 设置过滤不需要拦截的路径地址,尤其是登录地址一定要加上
        .excludePathPatterns("/users/index", "/error","/users/login","/static/**","/users/info","/users/addUser");
		

	}
	
	@Bean("sqlSessionFactory")
    public SqlSessionFactory getSqlSessionFactory(@Qualifier("dataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        // 读取mapper 配置文件
        Resource[] resources = new PathMatchingResourcePatternResolver().getResources("classpath:mappers/*Mapper.xml");
        factoryBean.setMapperLocations(resources);
        factoryBean.setTypeAliasesPackage("com.feifan.to");
        // 配置驼峰命名规则
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setMapUnderscoreToCamelCase(true);
        factoryBean.setConfiguration(configuration);
        // 加入SQL 语句执行拦截器
        factoryBean.setPlugins(new Interceptor[] {m});
        return   (SqlSessionFactory) factoryBean.getObject();
    }
	
	

	
	
}
