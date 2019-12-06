package com.course.testng.multiThread;

import org.testng.annotations.Test;
/**
 * 多线程XML方式实现
 * */
public class multiThreadOnXml {

    @Test
    private void test1(){
        System.out.printf("Thread Id: %s%n",Thread.currentThread().getId());
    }

    @Test
    private void test2(){
        System.out.printf("Thread Id: %s%n",Thread.currentThread().getId());
    }

    @Test
    private void test3(){
        System.out.printf("Thread Id: %s%n",Thread.currentThread().getId());
    }
}
