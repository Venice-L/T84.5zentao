package com.first.pages.productpages;

import org.openqa.selenium.WebDriver;

import com.first.uiframework.BasePage;
import com.first.uiframework.Locator;

public class MainPage extends BasePage {
      
      
     //构造 方法
      public MainPage(WebDriver dr){
    	 super(dr); 
      }
     Locator userMenu=getLocator("userMenu"); 
	//获取登录的用户名
      public String getLoginUsername(){
    	  wait(2);
		return getText(userMenu);
    	  
      }
}
