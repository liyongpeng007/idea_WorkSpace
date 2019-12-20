package com.course.httpclient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForGet {

    private String url;                 //用来存放登录url
    private ResourceBundle bundle;      //针对不同语言所使用的属性
    private CookieStore store;          //用来存储cookies信息的变量

    @BeforeTest
    public void beforeTest(){
        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
        //引用地址
        url = bundle.getString("test.url");
    }

    @Test
    public void testGetCookies() throws IOException {
        String result;
        //从配置文件中 拼接测试的url
        String uri = bundle.getString("getCookies.uri");
        String testUrl = this.url+uri;

        //测试逻辑代码书写
        HttpGet get = new HttpGet(testUrl);
        DefaultHttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(get);
        result = EntityUtils.toString(response.getEntity(),"utf-8");        //EntityUtils对象是org.apache.http.util下的一个工具类
        /*System.out.println(result);*/
        System.out.println(result);

        //获取cookies信息
        this.store = client.getCookieStore();
        //将cookie信息放入List集合中
        List<Cookie> cookieList = store.getCookies();
        //遍历cookie信息
        for (Cookie cookie : cookieList){
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("cookie name = " + name + ";cookie value = " + value);
        }
    }

    @Test(dependsOnMethods = "testGetCookies")
    public void testGetWithCookies() throws IOException{
        //从配置文件中 拼接测试的url
        String uri = bundle.getString("test.get.with.cookies");
        String testUrl = this.url+uri;
        //将拼接的url放入HttpGet中
        HttpGet get = new HttpGet(testUrl);
        DefaultHttpClient client = new DefaultHttpClient();
        //设置cookie信息
        client.setCookieStore(this.store);
        //将cookie信息放入响应中
        HttpResponse response = client.execute(get);
        //获取响应的状态码
        int statusCode = response.getStatusLine().getStatusCode();
        //对状态码进行判断
        if(statusCode == 200){
            String result = EntityUtils.toString(response.getEntity());
            System.out.println(result);
        }else{
            System.out.println("获取cookies失败！！！");
        }
    }
}
