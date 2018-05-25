package com.first.actions;

import org.openqa.selenium.WebDriver;

import com.first.pages.productpages.LoginPage;
import com.first.pages.productpages.MainPage;

public class LoginOperate {
   private static WebDriver driver;
   
   public static WebDriver getDriver(){
	return driver;
   }
   public static void setDriver(WebDriver driver){
	   LoginOperate.driver =driver;
   }
   //改装后不受业务限制
   static LoginPage loginPage;
   static MainPage mainPage;
   
   public static MainPage LoginSuess(String name,String password){
	   loginPage =new LoginPage(getDriver());
	   loginPage.inputUserName(name);
	   loginPage.inputPassWord(password);
	   loginPage.clickLoginButton();
	return new MainPage(getDriver());
   }
   
   public static String getLoginName(String name,String password){
	   mainPage = LoginSuess(name,password);
	return mainPage.getLoginUsername();
	   
   }

}
