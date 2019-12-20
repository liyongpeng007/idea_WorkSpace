package com.course.httpclient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.swing.text.html.parser.Entity;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForPosts {

   private String url;
   private ResourceBundle bundle;
   private CookieStore store;

   @BeforeTest
    public void beforeTest(){
       bundle = ResourceBundle.getBundle("application", Locale.CHINA);
       url = bundle.getString("getCookies.uri");
   }

   @Test
    public void testPostCookie() throws IOException {
       String uri = bundle.getString("test.post.with.cookies");
       String testUrl = this.url+uri;
       DefaultHttpClient client = new DefaultHttpClient();
       HttpGet get = new HttpGet();
       HttpResponse response = client.execute(get);
       String result = EntityUtils.toString(response.getEntity(),"utf-8");

       this.store = client.getCookieStore();
       List<Cookie> cookieList = store.getCookies();
       for (Cookie cookie : cookieList){
           String name = cookie.getName();
           String value = cookie.getValue();
       }
   }

   @Test(dependsOnMethods = "testPostCookie")
    public void testPostWithCookie() throws IOException{
      String result;
       String uri = bundle.getString("test.post.with.cookies");
       String testUrl = this.url+uri;
       DefaultHttpClient client = new DefaultHttpClient();
       HttpPost post = new HttpPost();
       JSONObject param = new JSONObject();
       param.put("name","huhansan");
       param.put("age","18");
       StringEntity entity = new StringEntity(param.toString(),"utf-8");
       post.setEntity(entity);
       post.setHeader("Content-type","application/json");
       client.setCookieStore(this.store);
       HttpResponse response =  client.execute(post);
       result = EntityUtils.toString(response.getEntity(),"utf-8");
       JSONObject resultJson = new JSONObject();
       String success = (String) resultJson.get("huhansan");
       String status = (String) resultJson.get("200");
      Assert.assertEquals("success",success);
      Assert.assertEquals("status",status);


   }
}
