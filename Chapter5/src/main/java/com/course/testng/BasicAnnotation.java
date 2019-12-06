package com.course.testng;

import org.testng.annotations.*;

public class BasicAnnotation {
    //最基本的注解，用来把方法标记为测试的一部分
    @Test
    public void testCase1(){
        System.out.println("这是一个测试的方法");
    }

    @Test
    public void testCase2(){
        System.out.println("这是测试方法2");
    }

    @BeforeMethod           //方法前运行
    public void beforeMethod(){
        System.out.println("这是在测试方法之前运行的");
    }

    @AfterMethod            //方法后运行
    public void afterMethod(){
        System.out.println("这是在方法之后运行的");
    }

    @BeforeClass            //在类前运行
    public void beforeClass(){
        System.out.println("这是在类之前运行的");
    }

    @AfterClass             //在类后运行
    public void afterClass(){
        System.out.println("这是在类之后运行的");
    }

    @BeforeSuite            //在测试套件前运行
    public void beforeSuite(){
        System.out.println("beforeSuite测试套件");
    }

    @AfterSuite             //在测试套件后运行
    public void afterSuite(){
        System.out.println("afterSuite测试套件");
    }


    /**
     * 验证multiThreadOnXml      xml文件中的classs级别
     * */
    @Test
    private void test5(){
        System.out.printf("Thread Id: %s%n",Thread.currentThread().getId());
    }

    @Test
    private void test6(){
        System.out.printf("Thread Id: %s%n",Thread.currentThread().getId());
    }

    @Test
    private void test8(){
        System.out.printf("Thread Id: %s%n",Thread.currentThread().getId());
    }
}
