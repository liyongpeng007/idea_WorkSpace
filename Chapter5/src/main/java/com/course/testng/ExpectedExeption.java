package com.course.testng;

import org.testng.annotations.Test;
/**
 * 异常测试
 * */
public class ExpectedExeption {

    /**
     * 这是一个失败的异常测试
     * */
    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeExceptionFail(){
        System.out.println("这是我的异常测试");
    }

    /**
     * 这是一个成功的异常测试
     * */
    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeExceptionSuccess(){
        System.out.println("这是我的一个异常测试");
        throw new RuntimeException();
    }
}
