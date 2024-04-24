package com.example.springtest;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class SpringTestApplication {

    @GetMapping("/hello")
    @WebLog(desc="这是一个欢迎接口")
    public String hello(String name){
        return "Hello"+name;
    }

    @Autowired
    Rectangle rectangle1;//可以正常运行

    public static void main(String[] args) throws Exception {
//        SpringApplication.run(SpringTestApplication.class, args);
        ApplicationContext context = new
                ClassPathXmlApplicationContext(
                "spring-config.xml");

        Rectangle r1 = context.getBean("rectangle", Rectangle.class);
        Rectangle r2 = context.getBean("rectangle", Rectangle.class);
        System.out.println(r1==r2);


//        ApplicationContext context1 = new FileSystemXmlApplicationContext("");
        PersonBean personBean = (PersonBean) context.getBean("personBean");
        personBean.work();
        personBean.destroy();
        personBean.destroyMethod();

    }

}
