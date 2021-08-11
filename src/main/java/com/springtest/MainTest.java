package com.springtest;

import com.springtest.bean.Person;
import com.springtest.bean.PersonFactoryBean;
import com.springtest.config.MainConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Administrator
 * @date 2021/8/10 22:33
 */
public class MainTest {
    public static void main(String[] args) {


        AnnotationConfigApplicationContext annotationContext
                =new AnnotationConfigApplicationContext(MainConfig.class);

        Object obj1=annotationContext.getBean("person01");

        System.out.println(obj1);
        String[] beanNames=annotationContext.getBeanNamesForType(Person.class);
        for(String name:beanNames){
            System.out.println(name);
        }

        //虽然这里写按照id写的是 personFactoryBean，但是返回的bean类型是 Person
        Object obj2=  annotationContext.getBean("personFactoryBean");
        System.out.println(obj2.getClass());


        Object obj3=  annotationContext.getBean("personFactoryBean");
        //判断是否是单例
        System.out.println(obj2==obj3);

        //如果就想要获得personFactoryBean本身的话，可加前缀 &
        Object obj4=  annotationContext.getBean("&personFactoryBean");
        System.out.println(obj4.getClass());


        //总结:
        //给容器注册中注册主键：
        //1、包扫描+组件扫描注解（@Controller/@Service@Repositroy@Component）
        //2、@Bean（导入第三方包里的组件）
        //3、@Import[快速给容器导入一个组件]
        //4、使用Spring框架提供的FactoryBean(工厂bean)
        // 1、默认返回的是getObject（）中的对象
        // 2、如果想要获取工厂bean本身，可以在id前面 加一个 &


        annotationContext.close();

        //bean生命周期
        //实例化：
        //  单实例：在容器启动时创建对象
        //  多实例：在每次获取时创建对象

        //填充属性

        //初始化
        //  对象创建完成，并赋值好，调用初始化方法

        //销毁
        // 单实例，容器关闭时执行指定的销毁方法
        // 多实例，容器哪怕在关闭时都不会管理bean，容器不会执行销毁方法，如果想要销毁只能自己手动调用
        //其中初始化和销毁可通过下列方式
        // （1） 通过@Bean 指定初始化和销毁方法
        // （2） 通过让 bean 实现 InitializingBean(定义初始化逻辑)；DisposableBean(定义销毁逻辑)
        // （3）通过使用JSR250，JSR是Java Specification Requests——java 规范要求 ，@PostConstruct,在bean实例化和填充属性完成后执行；@PreDestory,在容器销毁bean之前通知我们进行清理工作
    }
}
