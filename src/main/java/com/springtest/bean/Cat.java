package com.springtest.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @author Administrator
 * @date 2021/8/10 23:44
 */

@Component
public class Cat implements InitializingBean, DisposableBean {
    public Cat(){
        System.out.println("cat contructor...");
    }

    public void destroy() throws Exception {
        System.out.println("cat  destroy()...");
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("cat  init()...");
    }
}
