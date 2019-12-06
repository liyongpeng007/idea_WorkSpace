package com.course.testng.group;

import org.testng.annotations.Test;

@Test(groups="student")
public class GroupsOnClass3 {

    public void student1(){
        System.out.println("GroupsOnClass3中的student1运行");
    }

    public void student2(){
        System.out.println("GroupsOnClass3中的student2运行");
    }
}
