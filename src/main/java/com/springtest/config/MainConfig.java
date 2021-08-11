package com.springtest.config;

import com.springtest.bean.Color;
import com.springtest.bean.Person;
import com.springtest.bean.PersonFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author Administrator
 * @date 2021/8/10 22:34
 */

//标明该类为配置类
@Configuration
@ComponentScan("com.springtest")
public class MainConfig {

    //给容器注册一个bean;类型为返回值类型,id默认是方法名
    @Bean("person01")
    public Person person(){
        return new Person("LISI",24);
    }


    //使用Spring框架提供的FactoryBean(工厂bean)
    @Bean
    public PersonFactoryBean personFactoryBean(){
        return new PersonFactoryBean();
    }

    @Bean(initMethod = "init" ,destroyMethod = "destory")
    @Scope("prototype")
    public Color color(){
        return new Color();
    }


}
