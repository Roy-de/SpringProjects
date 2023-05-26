package com.example.demo.BeanTest;

import com.example.demo.beans.InfoBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanTest {
    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        InfoBean infobean = (InfoBean) context.getBean("info");
        infobean.display();
    }
}
