package com.course.testng.paramter;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
/**
 * 参数化测试--xml文件参数化
 * */
public class ParamterTest {

    @Test
    @Parameters({"name","age"})
    public void paramTest1(String name,int age){
        System.out.println();
        System.out.println("name = " + name + "; age = " + age);
    }
}
