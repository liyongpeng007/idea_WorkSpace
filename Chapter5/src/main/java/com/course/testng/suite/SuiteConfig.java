package com.course.testng.suite;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class SuiteConfig {

    @BeforeSuite
    public void beforeSuit(){
        System.out.println();
        System.out.println("before suite运行啦");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("after suite运行啦");
    }
}
