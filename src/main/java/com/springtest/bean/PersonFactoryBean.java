package com.springtest.bean;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author Administrator
 * @date 2021/8/10 22:52
 */
public class PersonFactoryBean implements FactoryBean<Person> {
    public Person getObject() throws Exception {
        return new Person("lisi",24);
    }

    public Class<?> getObjectType() {
        return Person.class;
    }

    //是否是单例
    public boolean isSingleton() {
        return true;
    }
}
