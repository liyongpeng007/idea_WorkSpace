package com.course.testng;

import org.testng.annotations.Test;

/**
 * 超时测试
 * */
public class TimeTest {

    /**
     * 成功的测试
     * */
    @Test(timeOut = 3000)//单位为毫秒值
    public void testSuccess() throws InterruptedException{
        Thread.sleep(2000);
    }

    /**
     * 失败的测试
     * */
   /* @Test(timeOut = 2000)
    public void testFile() throws InterruptedException{
        Thread.sleep(3000);
    }*/
}
