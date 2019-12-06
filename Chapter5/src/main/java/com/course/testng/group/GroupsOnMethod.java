package com.course.testng.group;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
/**
 * 方法分组测试
 * */
public class GroupsOnMethod {
    @Test(groups = "server")
    public void test1(){
        System.out.println("服务端组测试方法111111111");
    }

    @Test(groups = "server")
    public void test2(){
        System.out.println("服务端组测试方法222222222");
    }

    @Test(groups = "client")
    public void test3(){
        System.out.println("客户端组测试方法222222222");
    }

    @Test(groups = "client")
    public void test4(){
        System.out.println("客户端组测试方法222222222");
    }

    @BeforeGroups("server")
    public void beforeOnGroups1(){
        System.out.println("这是服务端组运行前的测试方法");
    }

    @AfterGroups("server")
    public void afterOnGroups2(){
        System.out.println("这是服务端组运行后的测试方法");
    }
}
